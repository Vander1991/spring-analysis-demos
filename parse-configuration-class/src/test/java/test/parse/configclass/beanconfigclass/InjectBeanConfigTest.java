package test.parse.configclass.beanconfigclass;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import parse.configclass.scanconfig.InjectBeanConfig;

/**
 * @author : Vander
 * @date :   2021/1/25
 * @description :
 */
public class InjectBeanConfigTest {

    @Test
    public void testConfiguration() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(InjectBeanConfig.class);
        applicationContext.refresh();
        System.out.println(applicationContext.getBean("winnie"));
    }

}
