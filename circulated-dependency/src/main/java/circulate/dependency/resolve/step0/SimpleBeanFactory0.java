package circulate.dependency.resolve.step0;

import circulate.dependency.resolve.base.BeanFactory;
import circulate.dependency.resolve.util.AutowiredAnnotationBeanUtil;
import circulate.dependency.resolve.util.DefaultSingletonBeanRegistry;
import org.springframework.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : Vander
 * @date :   2021/5/29
 * @description :
 */
public class SimpleBeanFactory0 extends DefaultSingletonBeanRegistry implements BeanFactory {

    private AutowiredAnnotationBeanUtil autowiredAnnotationBeanUtil = new AutowiredAnnotationBeanUtil(this);

    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String beanName) {
        Object instance = null;
        try {
            // 判断单例池中是否存在Bean
            if (singletonObjects.containsKey(beanName)) {
                return singletonObjects.get(beanName);
            }

            // 实例化
            instance = doCreateBean(beanName);

            // 属性填充
            autowiredAnnotationBeanUtil.fillAttribute(instance);

            // 缓存到单例池
            singletonObjects.put(beanName, instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }

    public Object doCreateBean(String beanName) throws Exception {
        BeanDefinition beanDefinition = super.getBeanDefinitionMap().get(beanName);
        Class<?> beanClass = Class.forName(beanDefinition.getBeanClassName());
        Object instance = beanClass.newInstance();
        return instance;
    }

    @Override
    public <T> T getBean(String beanName, Class<T> requiredType) {
        Object bean = getBean(beanName);
        if (requiredType != null && requiredType.isInstance(bean)) {
            return (T) bean;
        }
        return null;
    }

}
