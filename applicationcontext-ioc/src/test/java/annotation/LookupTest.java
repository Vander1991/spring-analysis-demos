package annotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.demo.lookup.AbstractKitchen;
import spring.demo.lookup.Employee;
import spring.demo.lookup.MediaKitchen;

/**
 * @author : Vander
 * @date :   2020/11/4
 * @description :
 */
public class LookupTest {

    @Test
    public void testLookup() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("spring.demo.lookup");

        AbstractKitchen abstractKitchen = applicationContext.getBean("abstractKitchen", AbstractKitchen.class);
        abstractKitchen.printRefrigerator();

        AbstractKitchen mediaKitchen = applicationContext.getBean("mediaKitchen", AbstractKitchen.class);
        mediaKitchen.printRefrigerator();

        for (int i = 0; i < 3; i++) {
            Employee employee = (Employee) applicationContext.getBean("employee");
            System.out.print("takeClothes : ");
            employee.takeClothes();
        }

        for (int i = 0; i < 3; i++) {
            Employee employee = (Employee) applicationContext.getBean("employee");
            System.out.print("takeClothes2 : ");
            employee.takeClothes2();
        }

    }

}

