package parse.configclass.importannotation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import parse.configclass.importannotation.ImportBDRegistrarImpl;
import parse.configclass.importannotation.model.Student;
import parse.configclass.importannotation.model.Teacher;

/**
 * @author : Vander
 * @date :   2021/1/26
 * @description : 两个beanMethod，第二个beanMethod不会把第一个覆盖
 */
@Configuration
@Import({Student.class, ImportBDRegistrarImpl.class, Teacher.class})
public class AppConfig {

//    @Bean
//    public Student student(@Autowired(required = false) String stuId, @Autowired(required = false) String stuName) {
//        System.out.println("AppConfig#student1");
//        return new Student();
//    }
//
//    @Bean
//    public Student student(@Autowired(required = false) String name) {
//        System.out.println("AppConfig#student2");
//        return new Student();
//    }

}
