package test.infer.constructor.util;

import org.junit.Test;
import org.springframework.util.ClassUtils;

/**
 * @author : Vander
 * @date :   2021/1/29
 * @description :
 */
public class ClassUtilsTest {

    @Test
    public void test() {
        System.out.println(ClassUtils.isAssignable(Refrigerator.class, MediaRefrigerator.class));
        // JDK查看是否是某个类派生出来的
        System.out.println(Refrigerator.class.isAssignableFrom(Refrigerator.class));
        System.out.println(Refrigerator.class.isAssignableFrom(MediaRefrigerator.class));
        System.out.println(MediaRefrigerator.class.isAssignableFrom(Refrigerator.class));
    }

    public static class Refrigerator {}

    public static class MediaRefrigerator extends Refrigerator{}

}
