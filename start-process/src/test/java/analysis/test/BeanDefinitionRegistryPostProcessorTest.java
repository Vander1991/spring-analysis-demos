package analysis.test;

import analysis.demo.postprocess.config.AppConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Vander
 * @date :   2021/1/24
 * @description :
 */
public class BeanDefinitionRegistryPostProcessorTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(annotationConfigApplicationContext.getBean("stu"));
    }

}
