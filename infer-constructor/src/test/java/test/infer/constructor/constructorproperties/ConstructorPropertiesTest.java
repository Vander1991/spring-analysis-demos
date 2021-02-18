package test.infer.constructor.constructorproperties;

import infer.constructor.constructorproperties.config.AppConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Vander
 * @date :   2021/1/28
 * @description :
 */
public class ConstructorPropertiesTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(annotationConfigApplicationContext.getBean("teacher"));
    }

}
