package spring.aop.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author : Vander
 * @date :   2021/2/5
 * @description :
 */
@ComponentScan("spring.aop.common")
@EnableAspectJAutoProxy
public class AppConfig {
}
