package annotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.demo.model.Fan;
import spring.demo.value.Classroom;

/**
 * @author : Vander
 * @date :   2021/1/18
 * @description :
 */
public class ValueTest {

    @Test
    public void testValue() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext("spring.demo.value");
        Classroom classroom = (Classroom) annotationConfigApplicationContext.getBean("classroom");
        Fan fan = classroom.getFan();
        System.out.println(fan);
    }

}
