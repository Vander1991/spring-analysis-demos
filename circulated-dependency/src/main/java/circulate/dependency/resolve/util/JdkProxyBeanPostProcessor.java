package circulate.dependency.resolve.util;

import circulate.dependency.common.model.Husband;
import circulate.dependency.common.model.SinglePerson;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;

import java.lang.reflect.Method;

/**
 * @author : Vander
 * @date :   2021/5/29
 * @description :
 */
public class JdkProxyBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {

    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        Object proxy = bean;
        if (bean instanceof Husband) {
            ProxyFactory proxyFactory = new ProxyFactory();
            proxyFactory.setTarget(bean);
            proxyFactory.addAdvice(new MethodBeforeAdvice() {
                @Override
                public void before(Method method, Object[] args, Object target) throws Throwable {
                    // method是当前调用的方法，target为原始对象，args为传入的实参
                    if (method.getName().contains("makeMoney")) {
                        System.out.println("org.springframework.aop.MethodBeforeAdvice#before make money!!!");
                    }
                }
            });
            proxy = proxyFactory.getProxy();
        }

        if (bean instanceof SinglePerson) {
            ProxyFactory proxyFactory = new ProxyFactory();
            proxyFactory.setTarget(bean);
            proxyFactory.addAdvice(new MethodBeforeAdvice() {
                @Override
                public void before(Method method, Object[] args, Object target) throws Throwable {
                    // method是当前调用的方法，target为原始对象，args为传入的实参
                    if (method.getName().contains("print")) {
                        System.out.println("org.springframework.aop.MethodBeforeAdvice#before print!!!");
                    }
                }
            });
            proxy = proxyFactory.getProxy();
        }
        return proxy;
    }

}
