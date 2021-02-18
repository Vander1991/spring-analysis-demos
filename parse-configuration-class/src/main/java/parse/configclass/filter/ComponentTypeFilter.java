package parse.configclass.filter;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author : Vander
 * @date :   2021/1/26
 * @description : 适配器模式
 */
public class ComponentTypeFilter implements TypeFilter {

    private TypeFilter typeFilter = new AnnotationTypeFilter(Component.class);

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        return typeFilter.match(metadataReader, metadataReaderFactory);
    }
}
