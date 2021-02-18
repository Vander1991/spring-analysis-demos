package xml;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.demo.autowire.mode.Office;

/**
 * @author : Vander
 * @date :   2020/11/18
 * @description :
 */
public class AutowireModeTest {

    @Test
    public void testByType() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-autowiremode.xml");
        Office office = (Office) applicationContext.getBean("office1");
        System.out.println(office);
    }

    @Test
    public void testByName() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-autowiremode.xml");
        Office office = (Office) applicationContext.getBean("office2");
        System.out.println(office);
    }


}
