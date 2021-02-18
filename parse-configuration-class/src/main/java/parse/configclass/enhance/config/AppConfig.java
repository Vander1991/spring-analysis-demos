package parse.configclass.enhance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import parse.configclass.enhance.model.Student;
import parse.configclass.enhance.model.Teacher;

/**
 * @author : Vander
 * @date :   2021/1/27
 * @description :
 */
@ComponentScan("parse.configclass.enhance")
@Configuration
public class AppConfig {

    @Bean
    public Student student() {
        return new Student();
    }

    @Bean
    public Teacher teacher() {
        // 此处的Student若是通过@Configuration配置类注入的，则拿到的单例池里的，
        // 若AppConfig不是@Configuration的，则student是一个新创建的对象，相当于调用了一次student()方法
        return new Teacher(student());
    }

}
