package converter;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Vander
 * @date :   2020/10/29
 * @description :
 */
public class FactoryBeanTest {

    @Test
    public void testFactoryBean() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("spring.demo.config");
        System.out.println(applicationContext.getBean("carFactoryBean"));
        System.out.println(applicationContext.getBean("&carFactoryBean"));
    }

}
