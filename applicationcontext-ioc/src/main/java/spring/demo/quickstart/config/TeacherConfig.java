package spring.demo.quickstart.config;

import org.springframework.context.annotation.Bean;
import spring.demo.quickstart.model.Teacher;

/**
 * @author : Vander
 * @date :   2021-05-28
 * @description :
 */
public class TeacherConfig {

    @Bean
    public Teacher teacherLi() {
        return new Teacher("001", "Mr.Li");
    }

}
