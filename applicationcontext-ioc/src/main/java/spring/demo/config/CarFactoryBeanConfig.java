package spring.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.demo.factory.CarFactoryBean;

/**
 * @author : Vander
 * @date :   2020/10/29
 * @description :
 */
@Configuration
public class CarFactoryBeanConfig {

    @Bean
    public CarFactoryBean carFactoryBean() {
        CarFactoryBean carFactoryBean = new CarFactoryBean();
        carFactoryBean.setCarInfo("Mercedes-Benz,400,2000000");
        return carFactoryBean;
    }

}
