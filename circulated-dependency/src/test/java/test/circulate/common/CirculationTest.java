package test.circulate.common;

import circulate.dependency.common.config.AppConfig;
import circulate.dependency.common.model.Husband;
import circulate.dependency.common.model.Wife;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Vander
 * @date :   2021/2/1
 * @description :
 */
public class CirculationTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Husband husband = applicationContext.getBean("husband", Husband.class);
        Wife wife = applicationContext.getBean("wife", Wife.class);
        husband.makeMoney();
        husband.printMyWife();
        wife.printMyHusband();
    }

}
