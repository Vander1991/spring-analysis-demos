import converter.ValueConverter;
import org.junit.Test;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.demo.autowire.config.FanConfig;
import spring.demo.model.Car;
import spring.demo.service.HelloService;

import java.util.Locale;
import java.util.Map;

/**
 * @author : Vander
 * @date :   2020/10/22
 * @description :
 */
public class AnnotationConfigApplicationContextTest {

    @Test
    public void testOrder() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(FanConfig.class);
    }

    @Test
    public void testGetBean() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("spring.demo.service");
        HelloService helloService = (HelloService)applicationContext.getBean("helloService");
        helloService.sayHello();
    }

    @Test
    public void testRegister() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(applicationContext);
        annotatedBeanDefinitionReader.register(Car.class);
        applicationContext.refresh();
        System.out.println(applicationContext.getBean("car"));
    }

    /**
     * 测试环境变量获取
     */
    @Test
    public void testEnvironment() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        Map<String, Object> systemProperties = applicationContext.getEnvironment().getSystemProperties();
        System.out.println(systemProperties.get("java.class.path"));
    }

    /**
     * 国际化测试
     */
    @Test
    public void testMessage() throws Exception {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("spring.demo.config");
        System.out.println(applicationContext.getMessage("key", null, new Locale("en")));
        String message = applicationContext.getMessage("key", null, new Locale("CN"));
        // properties文件默认是以ISO-8859-1来读取的
        byte[] bytes = message.getBytes("ISO-8859-1");
        String s = new String(bytes, "utf-8");
        System.out.println(s);
    }

    @Test
    public void testPublishEvent() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("spring.demo.config");
        applicationContext.publishEvent("hello spring event!!!");
    }

    @Test
    public void testConverter() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("spring.demo.config");
        applicationContext.scan("converter");
        ValueConverter valueConverter = (ValueConverter) applicationContext.getBean("valueConverter");
        System.out.println(valueConverter.getCar());
    }

}
