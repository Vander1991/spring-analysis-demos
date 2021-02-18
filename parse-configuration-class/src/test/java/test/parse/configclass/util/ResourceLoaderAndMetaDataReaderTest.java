package test.parse.configclass.util;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import parse.configclass.filter.annotation.UserDefinedComponent;

import java.io.IOException;

/**
 * @author : Vander
 * @date :   2021/1/26
 * @description :
 */
public class ResourceLoaderAndMetaDataReaderTest {

    static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";

    final String basePackage = "parse.configclass.filter.model";

    @Test
    public void test() throws Exception {
        for (Resource resource : getResources(basePackage)) {
            // MetadataReader主要包含ClassMetadata和AnnotationMetadata
            MetadataReader metadataReader = new SimpleMetadataReaderFactory().getMetadataReader(resource);
            AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
            Assert.isTrue(annotationMetadata.hasAnnotation(UserDefinedComponent.class.getName()), "不包含指定的注解！！！");
            System.out.println(metadataReader);
        }
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
