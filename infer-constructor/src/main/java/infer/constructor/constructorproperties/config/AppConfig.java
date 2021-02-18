package infer.constructor.constructorproperties.config;

import infer.constructor.constructorproperties.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author : Vander
 * @date :   2021/1/27
 * @description :
 */
@ComponentScan("infer.constructor.constructorproperties")
@Configuration
public class AppConfig {

    @Bean
    public Student jason() {
        return new Student(2010130110, "jason");
    }

    @Bean
    public Student winnie() {
        return new Student(2013130520, "winnie");
    }

}
