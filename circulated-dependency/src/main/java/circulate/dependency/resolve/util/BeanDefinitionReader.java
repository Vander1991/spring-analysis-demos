package circulate.dependency.resolve.util;

import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * @author : Vander
 * @date :   2021/5/29
 * @description :
 */
public class BeanDefinitionReader {

    public BeanDefinition loadBeanDefinition(Class<?> beanClass) {
        BeanDefinition beanDefinition = new AnnotatedGenericBeanDefinition(beanClass);
        return beanDefinition;
    }

}
