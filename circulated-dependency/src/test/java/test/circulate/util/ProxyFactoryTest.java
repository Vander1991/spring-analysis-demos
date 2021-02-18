package test.circulate.util;

import circulate.dependency.common.model.Husband;
import org.junit.Test;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * @author : Vander
 * @date :   2021/2/1
 * @description :
 */
public class ProxyFactoryTest {

    @Test
    public void test() {
        Husband husband = new Husband();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(husband);
        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                // method是当前调用的方法，target为原始对象，args为传入的实参
                System.out.println("org.springframework.aop.MethodBeforeAdvice#before");
            }
        });
        Husband proxy = (Husband)proxyFactory.getProxy();
        proxy.makeMoney();
    }

}
