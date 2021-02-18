package infer.constructor.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author : Vander
 * @date :   2021/1/27
 * @description :
 */
@ComponentScan("infer.constructor.common")
@ImportResource("classpath:bean-autowiremode.xml")
@Configuration
public class AppConfig {

}
