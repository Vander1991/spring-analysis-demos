package lifecycle.analyse.config;

import lifecycle.analyse.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Vander
 * @date :   2021/5/25
 * @description :
 */
@Configuration
@ComponentScan("lifecycle.analyse")
public class AppConfig {

    @Bean("Jason")
    public Student jason() {
        return new Student("001", "Jason");
    }

}
