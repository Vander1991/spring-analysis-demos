package test.aop.spring;

import org.aopalliance.aop.Advice;
import org.junit.Test;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;
import spring.aop.common.model.Student;
import spring.aop.common.service.StudentService;
import spring.aop.common.service.StudentServiceImpl;

import java.lang.reflect.Method;

/**
 * @author : Vander
 * @date :   2021/2/5
 * @description :
 */
public class ProxyFactoryTest {

    @Test
    public void test() {
        Student student = new Student(2010130110, "jason");
        StudentServiceImpl studentService = new StudentServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory();

        // 通过设置接口，会优先使用JDK动态代理，以下其中之一作用类似
        // proxyFactory.setInterfaces(StudentService.class);
        // proxyFactory.addInterface(StudentService.class);

        // 使用此方式又会优先用CGLIB动态代理
        // proxyFactory.setTargetClass(StudentServiceImpl.class);

        proxyFactory.setTarget(studentService);
        proxyFactory.addAdvice(new AfterReturningAdvice() {
            @Override
            public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
                System.out.println("afterReturning:" + returnValue);
            }
        });
        StudentService studentServiceProxy = (StudentService)proxyFactory.getProxy();
        studentServiceProxy.examine(student);
        System.out.println(studentServiceProxy);
    }

}
