package test.aop.jdkproxy;

import org.junit.Test;
import spring.aop.common.model.Student;
import spring.aop.common.service.StudentService;
import spring.aop.common.service.StudentServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : Vander
 * @date :   2021/2/3
 * @description :
 */
public class JdkProxyTest {

    @Test
    public void test() {
        Student student = new Student(2010130110, "Jason");
        StudentServiceImpl studentService = new StudentServiceImpl();
        StudentService studentServiceProxy = (StudentService)Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class<?>[]{StudentService.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("java.lang.reflect.InvocationHandler.invoke");
                        return studentService.examine(student);
                    }
                });
        String result = studentServiceProxy.examine(student);
        System.out.println(result);
    }

}
