import org.junit.Test;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.OrderUtils;
import org.springframework.util.ClassUtils;
import spring.demo.autowire.config.FanConfig;

import java.lang.annotation.Annotation;

/**
 * @author : Vander
 * @date :   2021/1/18
 * @description :
 */
public class AnnotationUtilsTest {

    private static Class<? extends Annotation> priorityAnnotationType;

    static {
        try {
            priorityAnnotationType = (Class<? extends Annotation>)
                    ClassUtils.forName("org.springframework.context.annotation.Configuration",
                            AnnotationUtilsTest.class.getClassLoader());
        }
        catch (Throwable ex) {
            // javax.annotation.Priority not available
            priorityAnnotationType = null;
        }
    }

    @Test
    public void testFindAnnotation() {
        Annotation annotation = AnnotationUtils.findAnnotation(FanConfig.class, priorityAnnotationType);
        System.out.println(annotation.toString());
    }

}
