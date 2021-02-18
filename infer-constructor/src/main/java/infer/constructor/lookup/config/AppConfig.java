package infer.constructor.lookup.config;

import infer.constructor.lookup.model.Student;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Vander
 * @date :   2021/1/27
 * @description :
 */
@ComponentScan("infer.constructor.lookup")
@Configuration
public class AppConfig {

    @Lookup
    public Student student() {
        return null;
    }

}
