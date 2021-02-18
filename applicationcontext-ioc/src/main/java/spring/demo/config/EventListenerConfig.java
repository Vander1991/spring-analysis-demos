package spring.demo.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Vander
 * @date :   2020/10/26
 * @description :
 */
@Configuration
public class EventListenerConfig {
    @Bean
    public ApplicationListener applicationListener() {
        return new ApplicationListener() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.out.println(event.getSource().toString());
            }
        };
    }
}
