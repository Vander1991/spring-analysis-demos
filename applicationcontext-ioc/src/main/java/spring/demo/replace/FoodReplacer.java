package spring.demo.replace;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @author : Vander
 * @date :   2020/8/2
 * @description :
 */
public class FoodReplacer implements MethodReplacer {
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("reimplement init");
        System.out.println(method.getName());
        System.out.println("reimplement end");
        return null;
    }
}
