package test.parse.configclass.lookup;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Vander
 * @date :   2021/1/25
 * @description :
 */
public class LookupTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("parse.configclass.lookup.model");
        System.out.println(annotationConfigApplicationContext.getBean("chair"));
    }

}
