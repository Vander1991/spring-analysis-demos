package test.circulate.error;

import circulate.dependency.error2.config.AppConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Vander
 * @date :   2021/2/3
 * @description :
 */
public class Error2Test {

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(applicationContext.getBean("student"));
    }

}
