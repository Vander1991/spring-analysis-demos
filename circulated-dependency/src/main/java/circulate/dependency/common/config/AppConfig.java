package circulate.dependency.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author : Vander
 * @date :   2021/2/1
 * @description :
 */
@EnableAspectJAutoProxy
@ComponentScan("circulate.dependency.common")
public class AppConfig {
}
