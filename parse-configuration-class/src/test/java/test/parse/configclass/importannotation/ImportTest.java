package test.parse.configclass.importannotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import parse.configclass.importannotation.config.AppConfig;

/**
 * @author : Vander
 * @date :   2021/1/26
 * @description :
 */
public class ImportTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(annotationConfigApplicationContext.getBean("student"));
    }

}
