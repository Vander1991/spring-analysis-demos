package annotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.demo.autowire.Classroom;

/**
 * @author : Vander
 * @date :   2020/11/17
 * @description :
 */
public class AutowiredTest {

    @Test
    public void testAutowired() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext("spring.demo.autowire");
        Classroom classroom = (Classroom)annotationConfigApplicationContext.getBean("classroom");
        System.out.println(classroom.getFan());
        System.out.println(classroom);
    }

    @Test
    public void testInherit() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext("spring.demo.autowire.inherit");
        Object classroom = annotationConfigApplicationContext.getBean("mediaRefrigerator");
        System.out.println(classroom);
    }

}
