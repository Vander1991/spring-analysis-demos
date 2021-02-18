package test.parse.configclass.common;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import parse.configclass.common.config.AppConfig;

/**
 * @author : Vander
 * @date :   2021/1/25
 * @description :
 */
public class AnnotationConfigTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(annotationConfigApplicationContext.getBean("desk"));
    }

}
