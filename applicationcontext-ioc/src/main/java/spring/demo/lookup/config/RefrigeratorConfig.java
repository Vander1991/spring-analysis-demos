package spring.demo.lookup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.demo.model.Refrigerator;

/**
 * @author : Vander
 * @date :   2021-05-28
 * @description :
 */
@Configuration
public class RefrigeratorConfig {

    @Bean
    public Refrigerator refrigerator() {
        return new Refrigerator("001-Refrigerator");
    }

}
