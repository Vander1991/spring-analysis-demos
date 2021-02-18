package test.parse.configclass.enhance;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;
import parse.configclass.enhance.config.AppConfig;
import parse.configclass.enhance.model.Teacher;

/**
 * @author : Vander
 * @date :   2021/1/27
 * @description :
 */
public class ConfigurationClassEnhancerTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Assert.isTrue(applicationContext.getBean("student") ==
                ((Teacher)applicationContext.getBean("teacher")).getStudent(), "增加类取出的Student对象不一致");
    }

}
