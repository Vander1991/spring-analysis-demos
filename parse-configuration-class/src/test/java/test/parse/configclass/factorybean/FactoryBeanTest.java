package test.parse.configclass.factorybean;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import parse.configclass.factorybean.config.AppConfig;

/**
 * @author : Vander
 * @date :   2021/1/27
 * @description :
 */
public class FactoryBeanTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(annotationConfigApplicationContext.getBean("student"));
        System.out.println(annotationConfigApplicationContext.getBean("&student"));
    }

}
