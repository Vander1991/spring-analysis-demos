package annotation;

import org.junit.Test;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import spring.demo.autowire.Classroom;

import java.lang.reflect.Method;

/**
 * @author : Vander
 * @date :   2020/11/19
 * @description :
 */
public class AutowiredAnnotationBPTest {

    @Test
    public void testBuildAutowiringMetadata() throws Exception {
        AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor
                = new AutowiredAnnotationBeanPostProcessor();
        Method buildAutowiringMetadata = AutowiredAnnotationBeanPostProcessor.class
                .getDeclaredMethod("buildAutowiringMetadata", Class.class);
        buildAutowiringMetadata.setAccessible(true);
        InjectionMetadata result = (InjectionMetadata)buildAutowiringMetadata
                .invoke(autowiredAnnotationBeanPostProcessor, Classroom.class);
        System.out.println(result);
    }

}
