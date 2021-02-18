package parse.configclass.importannotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import parse.configclass.filter.annotation.UserDefinedComponent;

import java.io.IOException;
import java.util.Map;

/**
 * @author : Vander
 * @date :   2021/1/26
 * @description : Import的Teacher类上有UserDefinedComponent注解，扫描到了则生成BD到registry中
 */
@Slf4j
public class ImportBDRegistrarImpl implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        resolveUserDefinedComponent(importingClassMetadata);
        // 此处的importingClassMetadata是@Import对应的配置类的Metadata
        if (resolveUserDefinedComponent(importingClassMetadata)) {
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
            rootBeanDefinition.setBeanClass(importingClassMetadata.getClass());
            registry.registerBeanDefinition(importingClassMetadata.getClass().getName(), rootBeanDefinition);
        }
    }

    private boolean resolveUserDefinedComponent(AnnotationMetadata importingClassMetadata) {
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(Import.class.getName());
        SimpleMetadataReaderFactory metadataReaderFactory = new SimpleMetadataReaderFactory();
        for (Map.Entry<String, Object> entry : annotationAttributes.entrySet()) {
            Class<?>[] classes = (Class<?>[]) entry.getValue();
            for (Class<?> clazz : classes) {
                try {
                    MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(clazz.getName());
                    return metadataReader.getAnnotationMetadata().hasAnnotation(UserDefinedComponent.class.getName());
                } catch (IOException e) {
                    log.error("can not get clazz {}'s metadata",e );
                }
            }
        }
        return false;
    }

}
