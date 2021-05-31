package spring.demo.quickstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.demo.quickstart.model.Student;

/**
 * @author : Vander
 * @date :   2021-05-25
 * @description :
 */
@Configuration
public class AppConfig {

    @Bean("stu")
    public Student student() {
        return new Student("001", "Jason");
    }

}
