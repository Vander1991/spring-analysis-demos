package postprocess;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Vander
 * @date :   2020/11/5
 * @description :
 */
public class PostProcessorTest {

    @Test
    public void testPostProcessor() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext("spring.demo.postprocess");
        System.out.println(annotationConfigApplicationContext.getBean("car"));
    }

}
