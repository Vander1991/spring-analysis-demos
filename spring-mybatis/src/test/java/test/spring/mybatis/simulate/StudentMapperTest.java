package test.spring.mybatis.simulate;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.mybatis.simulate.config.AppConfig;
import spring.mybatis.simulate.service.StudentService;

/**
 * @author : Vander
 * @date :   2021/1/31
 * @description : 实现简易版的mybatis-spring整合
 * 原理
 *  1）Mapper在Registry中是以MyBatis的代理类存在的，具体是FactoryBean的实现类，构建FactoryBean的实现类实现相应的Mapper接口
 *  2）找出对应包下的mapper接口，通过自定义的PandaMapperScan实现，先解析注解定义的basePackages，再通过metaReader读取对应包下的所有mapper
 *  3）将找出来的Mapper全都注入到容器中（注入到容器中以FactoryBean存在，getObject时返回的是MyBatis对应Mapper的实现类）
 */
public class StudentMapperTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentService studentService = applicationContext.getBean(StudentService.class);
        System.out.println(studentService.selectById(2010130110));
    }

}
