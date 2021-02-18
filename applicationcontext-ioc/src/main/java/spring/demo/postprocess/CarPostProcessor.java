package spring.demo.postprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author : Vander
 * @date :   2020/11/5
 * @description :
 */
@Component
public class CarPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (beanClass.equals(Car.class)) {
            System.out.println("postProcessBeforeInstantiation: Car 实例化前");
            // 此处可以替换掉对应的Bean
//            return new Car("Ferrari", 250, 2500000);
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (bean.getClass().equals(Car.class)) {
            System.out.println("postProcessAfterInstantiation: Car 实例化后");
        }
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
            throws BeansException {
        if (bean.getClass().equals(Car.class)) {
            System.out.println("postProcessProperties: Car 依赖装配");
        }
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (bean.getClass().equals(Car.class)) {
            System.out.println("postProcessBeforeInitialization: Car 初始化前");
        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (bean.getClass().equals(Car.class)) {
            System.out.println("postProcessAfterInitialization: Car 初始化后");
        }
        return null;
    }

}
