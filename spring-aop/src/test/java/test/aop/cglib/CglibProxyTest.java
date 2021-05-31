package test.aop.cglib;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import spring.aop.common.model.Student;
import spring.aop.common.service.StudentService;
import spring.aop.common.service.StudentServiceImpl;

import java.lang.reflect.Method;

/**
 * @author : Vander
 * @date :   2021/2/5
 * @description :
 */
public class CglibProxyTest {

    @Test
    public void test() {
        Student student = new Student(2010130110, "jason");
        StudentService studentService = new StudentServiceImpl();
        MethodInterceptor methodInterceptor = new MethodInterceptorImpl();
        StudentService studentServiceProxy = (StudentService) getInstance(studentService, methodInterceptor);
        studentServiceProxy.doSomeSports(student);
    }

    /**
     * 创建有参构造的实体类
     *
     * @param obj
     * @param args
     * @param argsValue
     * @return
     */
    public Object getInstance(Object obj, Class[] args, Object[] argsValue, MethodInterceptor methodInterceptor) {
        Enhancer enhancer = new Enhancer();
        // 设置被代理类
        enhancer.setSuperclass(obj.getClass());
        // 设置代理类
        enhancer.setCallback(methodInterceptor);
        // 创建有参的增强类
        Object enhancerObj = enhancer.create(args, argsValue);
        return enhancerObj;
    }

    /**
     * 创建无参构造的实体类
     *
     * @param target
     * @return
     */
    public Object getInstance(Object target, MethodInterceptor methodInterceptor) {
        Enhancer enhancer = new Enhancer();
        // 设置被代理类
        enhancer.setSuperclass(target.getClass());
        // 设置代理类
        enhancer.setCallback(methodInterceptor);
        // 创建无参的增强类
        return enhancer.create();

    }

    class MethodInterceptorImpl implements MethodInterceptor {
        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy)
                throws Throwable {
            System.out.println("MethodInterceptorImpl.intercept:");
//            method.invoke(obj, args);
//            return null;
            return null;
        }
    }

}
