package circulate.dependency.resolve.step2;

import circulate.dependency.resolve.base.BeanFactory;
import circulate.dependency.resolve.util.AutowiredAnnotationBeanUtil;
import circulate.dependency.resolve.util.DefaultSingletonBeanRegistry;
import circulate.dependency.resolve.util.JdkProxyBeanPostProcessor;
import org.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : Vander
 * @date :   2021/5/29
 * @description :
 */
public class SimpleBeanFactory2 extends DefaultSingletonBeanRegistry implements BeanFactory {

    private AutowiredAnnotationBeanUtil autowiredAnnotationBeanUtil = new AutowiredAnnotationBeanUtil(this);
    /**
     * 一级缓存，存放原始的Bean
     */
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>();
    /**
     * 二级缓存，存放增强过的Bean（当二级缓存没有，一级缓存有时，说明bean已经经历了完整生命周期）
     */
    private final Map<String, Object> earlySingletonObjects = new HashMap<>();

    @Override
    public Object getBean(String beanName) {
        Object instance = null;
        try {
            // 先从缓存中获取
            instance = getSingleton(beanName);
            if (null != instance) {
                return instance;
            }

            // 实例化
            instance = doCreateBean(beanName);

            // AOP增强，增强后，注解信息会丢失，所以增强前先解析Bean中的注解并缓存起来
            Object earlyBeanReference = new JdkProxyBeanPostProcessor().getEarlyBeanReference(instance, beanName);

            // 原始对象加入一级缓存中，增强对象放入二级缓存
            singletonObjects.put(beanName, instance);
            earlySingletonObjects.put(beanName, earlyBeanReference);

            // 属性填充
            autowiredAnnotationBeanUtil.fillAttribute(instance);

            // 填充属性完毕后，需要查看是否要替换掉一级缓存中的Bean
            Object earlySingletonObject = earlySingletonObjects.remove(beanName);
            if (null != earlySingletonObject) {
                singletonObjects.put(beanName, earlyBeanReference);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return singletonObjects.get(beanName);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> requiredType) {
        Object bean = getBean(beanName);
        if (requiredType != null && requiredType.isInstance(bean)) {
            return (T) bean;
        }
        return null;
    }

    public Object doCreateBean(String beanName) throws Exception {
        BeanDefinition beanDefinition = super.getBeanDefinitionMap().get(beanName);
        Class<?> beanClass = Class.forName(beanDefinition.getBeanClassName());
        Object instance = beanClass.newInstance();
        return instance;
    }

    private Object getSingleton(String beanName) {
        // 先从一级缓存中获取
        Object singletonObject = null;
        if (singletonObjects.containsKey(beanName)) {
            singletonObject = singletonObjects.get(beanName);
        }

        // 一级缓存中获取不到，再从二级缓存中获取
        Object earlySingtonObject = null;
        if (earlySingletonObjects.containsKey(beanName)) {
            earlySingtonObject = earlySingletonObjects.get(beanName);
        }

        if (3 == findBeanNameFromMap(beanName)) {
            return earlySingtonObject;
        } else if (1 == findBeanNameFromMap(beanName)) {
            return singletonObject;
        }
        return null;
    }

    /**
     * 1-表示一级缓存有，2-表示二级缓存有，3-表示一级二级都有
     *
     * @param beanName
     * @return
     */
    private int findBeanNameFromMap(String beanName) {
        int storeFlag = 0;
        if (singletonObjects.containsKey(beanName)) {
            storeFlag = storeFlag + 1;
        }

        if (earlySingletonObjects.containsKey(beanName) && null != earlySingletonObjects.get(beanName)) {
            storeFlag = storeFlag + 2;
        }
        return storeFlag;
    }

}
