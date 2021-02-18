package framework.inject.config;

import framework.inject.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.annotation.PostConstruct;

/**
 * @author : Vander
 * @date :   2020/6/23
 * @description :
 */
@ConditionalOnProperty(
		value = "classroom.inject.enabled",
		havingValue = "true",
		matchIfMissing = true)
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class ClassroomConfig {

    @Bean
    public Student student() {
        Student student = new Student("2010130110", "jason");
        return student;
    }

    /**
     * 静态类会扫描，但是外围类不会被扫描
     */
    @Configuration
    protected static class GlobalPropertyConfiguration {

        @Autowired
        private Student student;

        @PostConstruct
        public void propertyRead() {
            System.out.println("propertyRead:" + student.toString());
        }

    }

}
