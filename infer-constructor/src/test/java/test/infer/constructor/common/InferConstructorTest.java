package test.infer.constructor.common;

import infer.constructor.common.config.AppConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Vander
 * @date :   2021/1/27
 * @description :
 */
public class InferConstructorTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        applicationContext.getBean("student");
    }

    @Test
    public void testGetBean() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(applicationContext.getBean("teacher"));
        System.out.println(applicationContext.getBean("student"));
        System.out.println(applicationContext.getBean("student", 2010130110));
        System.out.println(applicationContext.getBean("student", "Jason"));
        System.out.println(applicationContext.getBean("student", 2010130110, "Jason"));
    }

}
