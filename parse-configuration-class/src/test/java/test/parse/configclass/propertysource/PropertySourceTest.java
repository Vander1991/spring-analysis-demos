package test.parse.configclass.propertysource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import parse.configclass.propertysource.DataSourceConfig;

/**
 * @author : Vander
 * @date :   2021/1/25
 * @description :
 */
public class PropertySourceTest {

    @Test
    public void testProperty() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(DataSourceConfig.class);
        annotationConfigApplicationContext.refresh();
        ConfigurableEnvironment environment = annotationConfigApplicationContext.getEnvironment();
        System.out.println(environment.getProperty("spring.datasource.description"));
    }

}
