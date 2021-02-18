package spring.demo.autowire.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import spring.demo.model.Fan;

/**
 * @author : Vander
 * @date :   2020/12/11
 * @description :
 */
@Configuration("fanConfig")
public class FanConfig {

    @Bean
    public Fan fan1() {
        return new Fan();
    }

    @Bean
    @Order(2)
    public Fan fan2() {
        System.out.println("inject fan2");
        return new Fan();
    }

    @Bean
    @Order(1)
    public Fan fan3() {
        System.out.println("inject fan3");
        return new Fan();
    }

}
