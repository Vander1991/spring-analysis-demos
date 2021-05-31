package spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.aop.common.config.AppConfig;
import spring.aop.common.model.Student;
import spring.aop.common.service.StudentService;

/**
 * @author : Vander
 * @date :   2021/2/3
 * @description :
 */
public class Main {
    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentService studentService = applicationContext.getBean("studentService", StudentService.class);
        Student jason = new Student(1, "Jason");
        studentService.doSomeSports(jason);
    }
}
