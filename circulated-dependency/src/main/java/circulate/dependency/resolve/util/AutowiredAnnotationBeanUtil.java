package circulate.dependency.resolve.util;

import circulate.dependency.resolve.base.BeanFactory;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Vander
 * @date :   2021/5/29
 * @description :
 */
@Getter
public class AutowiredAnnotationBeanUtil {

    private BeanFactory beanFactory;

    public AutowiredAnnotationBeanUtil(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void fillAttribute(Object bean) {
        List<String> autowiredFields = findAutowiredFields(bean);
        for (String fieldName : autowiredFields) {
            inject(bean, fieldName);
        }
    }

    public void inject(Object bean, String fieldName) {
        Object autowiredBean = beanFactory.getBean(fieldName);
        try {
            Field field = bean.getClass().getDeclaredField(fieldName);
            if (autowiredBean != null) {
                ReflectionUtils.makeAccessible(field);
                field.set(bean, autowiredBean);
                field.setAccessible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> findAutowiredFields(Object bean) {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        List<String> fieldNames = new ArrayList<>();
        for (Field declaredField : declaredFields) {
            Annotation annotation = AnnotationUtils.findAnnotation(declaredField, Autowired.class);
            if (null != annotation) {
                fieldNames.add(declaredField.getName());
            }
        }
        return fieldNames;
    }
}
