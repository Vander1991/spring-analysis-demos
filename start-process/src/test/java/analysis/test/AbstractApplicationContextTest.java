package analysis.test;

import analysis.demo.common.config.AppConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Vander
 * @date :   2021/1/23
 * @description :
 */
public class AbstractApplicationContextTest {

    /**
     * 测试Environment中必须具有某些key，通过-D的方式
     */
    @Test
    public void testValidateRequiredProperties() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AppConfig.class);
        applicationContext.getEnvironment().setRequiredProperties("java.version");// 改成java.version就能成功
        applicationContext.refresh();
        System.out.println(applicationContext.getBean("fan"));
    }

}
