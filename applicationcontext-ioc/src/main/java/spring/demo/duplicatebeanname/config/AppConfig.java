package spring.demo.duplicatebeanname.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import spring.demo.duplicatebeanname.Student;

/**
 * @author : Vander
 * @date :   2021-05-28
 * @description : 不写@Component，但是要在AnnotationApplicationContext中传入
 */
@ComponentScan("spring.demo.duplicatebeanname")
public class AppConfig {

    @Bean("Jason")
    public Student jason(){
        return new Student("20200520", "Jason");
    }

}
