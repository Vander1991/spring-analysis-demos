import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

/**
 * @author : Vander
 * @date :   2020/10/22
 * @description :
 */
public class ClassPathBeanDefinitionScannerTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext();
        ClassPathBeanDefinitionScanner classPathBeanDefinitionScanner =
                new ClassPathBeanDefinitionScanner(annotationConfigApplicationContext);
        classPathBeanDefinitionScanner.scan("spring.demo.service");
        annotationConfigApplicationContext.refresh();
        System.out.println(annotationConfigApplicationContext.getBean("helloService"));
    }

}
