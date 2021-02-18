package spring.mybatis.simulate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.util.ClassUtils;
import spring.mybatis.simulate.annotation.PandaMapperScan;

import java.io.IOException;
import java.util.Map;

/**
 * @author : Vander
 * @date :   2021/1/31
 * @description :
 */
@Slf4j
public class PandaMapperScannerRegistrar implements ImportBeanDefinitionRegistrar {

    private static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        for (String basePackage : getBasePackages(importingClassMetadata)) {
            try {
                Resource[] resources = getResources(basePackage);
                for (Resource resource : getResources(basePackage)) {
                    // MetadataReader主要包含ClassMetadata和AnnotationMetadata
                    MetadataReader metadataReader = new SimpleMetadataReaderFactory().getMetadataReader(resource);
                    AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
                    String mapperClassname = annotationMetadata.getClassName();
                    GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
                    genericBeanDefinition.setBeanClassName(mapperClassname);
                    genericBeanDefinition.setBeanClass(MapperFactoryBean.class);
                    genericBeanDefinition.setFactoryBeanName(mapperClassname);
                    // 传入构造器的实参
                    ConstructorArgumentValues constructorArgumentValues = new ConstructorArgumentValues();
                    constructorArgumentValues.addIndexedArgumentValue(0, Class.forName(metadataReader.getClassMetadata().getClassName()));
                    genericBeanDefinition.setConstructorArgumentValues(constructorArgumentValues);
                    registry.registerBeanDefinition(mapperClassname, genericBeanDefinition);
                }
            } catch (IOException e) {
                log.error("parse basePackage:{}'s resource error!!!", basePackage, e);
            } catch (ClassNotFoundException e) {
                log.error("parse basePackage:{}'s resource error!!!", basePackage, e);
            }
        }

    }

    private String[] getBasePackages(AnnotationMetadata importingClassMetadata) {
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(PandaMapperScan.class.getName());
        String[] basePackages = (String[])annotationAttributes.get("basePackages");
        return basePackages;
    }

    public Resource[] getResources(String basePackage) throws IOException {
        String basePackagePath = ClassUtils.convertClassNameToResourcePath(basePackage);
        String resourcePath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + basePackagePath + '/' + DEFAULT_RESOURCE_PATTERN;
        System.out.println(resourcePath);
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = pathMatchingResourcePatternResolver.getResources(resourcePath);
        return resources;
    }

}
