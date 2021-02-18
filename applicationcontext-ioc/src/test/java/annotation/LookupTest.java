package annotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.demo.lookup.Employee;

/**
 * @author : Vander
 * @date :   2020/11/4
 * @description :
 */
public class LookupTest {

    @Test
    public void testLookup() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext("spring.demo.lookup");
        for (int i = 0; i < 3; i++) {
            Employee employee = (Employee) annotationConfigApplicationContext.getBean("employee");
            System.out.print("takeClothes : ");
            employee.takeClothes();
        }

        for (int i = 0; i < 3; i++) {
            Employee employee = (Employee) annotationConfigApplicationContext.getBean("employee");
            System.out.print("takeClothes2 : ");
            employee.takeClothes2();
        }

    }

}

