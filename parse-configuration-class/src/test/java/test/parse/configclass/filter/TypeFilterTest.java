package test.parse.configclass.filter;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import parse.configclass.filter.config.AppConfig;

/**
 * @author : Vander
 * @date :   2021/1/26
 * @description : 实现自定义注解，@ComponentScan扫描自定义注解和@Component
 */
public class TypeFilterTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(annotationConfigApplicationContext.getBean("teacher"));
        System.out.println(annotationConfigApplicationContext.getBean("student"));
    }

}
