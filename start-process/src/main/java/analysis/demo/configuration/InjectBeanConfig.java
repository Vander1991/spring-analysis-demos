package analysis.demo.configuration;

import analysis.demo.common.model.Student;
import org.springframework.context.annotation.Bean;

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
