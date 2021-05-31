package test.aop.util;

import org.junit.Test;
import spring.aop.common.service.StudentService;
import spring.aop.common.service.StudentServiceImpl;

/**
 * @author : Vander
 * @date :   2021-05-31
 * @description :
 */
public class IsAssignableFromTest {

    /**
     * 用于判断class的关系
     */
    @Test
    public void testIsAssignableFrom() {
        System.out.println(StudentServiceImpl.class.isAssignableFrom(StudentService.class));// false
        System.out.println(StudentService.class.isAssignableFrom(StudentServiceImpl.class));// true
    }

    /**
     * 用于判断对象的关系
     */
    @Test
    public void testInstanceOf() {
        StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
        System.out.println(studentServiceImpl instanceof StudentService);// true
    }

}
