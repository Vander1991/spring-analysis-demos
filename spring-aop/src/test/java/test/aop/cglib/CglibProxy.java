package test.aop.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理类
 */
public class CglibProxy implements MethodInterceptor {


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("——————调用真实对象前");
        Object result = methodProxy.invokeSuper(obj, args);
        System.out.println("——————调用真实对象后");
        return result;
    }

}
