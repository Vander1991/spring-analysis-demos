package test.infer.constructor.lookup;

import infer.constructor.lookup.config.AppConfig;
import infer.constructor.lookup.model.Student;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Constructor;

/**
 * @author : Vander
 * @date :   2021/1/27
 * @description : 加了@Lookup注解的factoryMethod，会每次getBean的时候都触发一次bean的生成
 */
public class LookupTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        for (int i = 0; i < 3; i++) {
            System.out.println(applicationContext.getBean("student"));
        }
    }

    @Test
    public void testSynthetic() {// 没搞懂
        for (Constructor<?> constructor : Student.class.getConstructors()) {
            if (constructor.isSynthetic()) {
                System.out.println(constructor + "为JVM生成的！");
            } else {
                System.out.println(constructor + "为人工生成的！");
            }
        }

    }

}
