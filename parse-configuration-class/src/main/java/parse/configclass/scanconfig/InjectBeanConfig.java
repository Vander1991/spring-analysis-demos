package parse.configclass.scanconfig;

import org.springframework.context.annotation.Bean;
import parse.configclass.model.Student;

/**
 * @author : Vander
 * @date :   2021/1/25
 * @description :
 */
public class InjectBeanConfig {

    @Bean
    public Student winnie() {
        return new Student("2141130154", "Winnie");
    }

}
