package duplicatebeanname;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.demo.duplicatebeanname.config.AppConfig;

/**
 * @author : Vander
 * @date :   2020/10/22
 * @description :
 */
public class DuplicateBeanNameTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(applicationContext.getBean("Jason"));
    }

}
