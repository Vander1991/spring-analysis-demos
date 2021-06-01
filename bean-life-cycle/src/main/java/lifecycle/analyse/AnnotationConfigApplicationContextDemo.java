package lifecycle.analyse;

import lifecycle.analyse.config.AppConfig;
import lifecycle.analyse.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Vander
 * @date :   2021/5/25
 * @description :
 */
@Slf4j
public class AnnotationConfigApplicationContextDemo {

    public static void main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Student jason = applicationContext.getBean("Jason", Student.class);
        log.info(jason.toString());
    }

}
