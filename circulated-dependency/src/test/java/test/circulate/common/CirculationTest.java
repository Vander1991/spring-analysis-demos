package test.circulate.common;

import circulate.dependency.common.config.AppConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Vander
 * @date :   2021/2/1
 * @description :
 */
public class CirculationTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(applicationContext.getBean("husband"));
    }

}
