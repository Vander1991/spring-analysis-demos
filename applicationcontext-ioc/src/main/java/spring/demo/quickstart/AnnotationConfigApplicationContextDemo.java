package spring.demo.quickstart;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.demo.quickstart.config.AppConfig;
import spring.demo.quickstart.config.TeacherConfig;
import spring.demo.quickstart.model.Student;
import spring.demo.quickstart.model.Teacher;

/**
 * @author : Vander
 * @date :   2021-05-25
 * @description :
 */
@Slf4j
public class AnnotationConfigApplicationContextDemo {

    public static void main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class, TeacherConfig.class);
        Student stu = applicationContext.getBean("stu", Student.class);
        Teacher teacherLi = applicationContext.getBean("teacherLi", Teacher.class);
        log.info(stu.toString());
        log.info(teacherLi.toString());
    }

}
