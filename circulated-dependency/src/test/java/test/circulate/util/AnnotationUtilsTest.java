package test.circulate.util;

import circulate.dependency.common.model.Husband;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AnnotationUtilsTest {

    @Test
    public void testFindAnnotation() {
        Field[] declaredFields = Husband.class.getDeclaredFields();
        List<Field> fields = new ArrayList<>();
        for (Field declaredField : declaredFields) {
            Annotation annotation = AnnotationUtils.findAnnotation(declaredField, Autowired.class);
            if (null != annotation) {
                fields.add(declaredField);
            }
        }
        for (Field field : fields) {
            System.out.println(field);
        }
    }

}