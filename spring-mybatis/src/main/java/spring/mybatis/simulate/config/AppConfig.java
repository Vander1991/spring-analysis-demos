package spring.mybatis.simulate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.mybatis.simulate.annotation.PandaMapperScan;
import spring.mybatis.simulate.model.Student;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Vander
 * @date :   2021/1/31
 * @description :
 */
@ComponentScan("spring.mybatis.simulate")
@Configuration
@PandaMapperScan(basePackages = {"spring.mybatis.simulate.mapper"})
public class AppConfig {

    @Bean
    public Map<Integer, Student> studentContent() {
        HashMap<Integer, Student> studentContent = new HashMap<>();
        studentContent.put(2010130110, new Student(2010130110, "Jason"));
        studentContent.put(2013130180, new Student(2013130180, "Panda"));
        return studentContent;
    }

}
