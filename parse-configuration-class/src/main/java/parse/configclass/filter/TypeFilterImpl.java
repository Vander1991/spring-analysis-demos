package parse.configclass.filter;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import parse.configclass.filter.annotation.UserDefinedComponent;

import java.io.IOException;

/**
 * @author : Vander
 * @date :   2021/1/26
 * @description :
 */
public class TypeFilterImpl implements TypeFilter {

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        return annotationMetadata.hasAnnotation(UserDefinedComponent.class.getName());
    }

}
