package parse.configclass.filter.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import parse.configclass.filter.ComponentTypeFilter;
import parse.configclass.filter.TypeFilterImpl;

/**
 * @author : Vander
 * @date :   2021/1/26
 * @description : new AnnotationTypeFilter(Component.class)
 */
@Component
@ComponentScan(basePackages = "parse.configclass.filter",
        includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM,
                classes = {TypeFilterImpl.class, ComponentTypeFilter.class})},
        useDefaultFilters = false)
public class AppConfig {
}
