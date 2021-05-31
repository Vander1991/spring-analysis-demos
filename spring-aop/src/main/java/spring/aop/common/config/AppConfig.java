package spring.aop.common.config;

import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import spring.aop.common.advice.PointcutAdvisorImpl;
import spring.aop.common.service.StudentService;
import spring.aop.common.service.StudentServiceImpl;

/**
 * @author : Vander
 * @date :   2021/2/5
 * @description :
 */
@ComponentScan("spring.aop.common")
@EnableAspectJAutoProxy
public class AppConfig {

    /**
     * 此Bean的本质是后置处理器
     *
     * @return
     */
    @Bean
    public BeanNameAutoProxyCreator creator() {
        BeanNameAutoProxyCreator proxyCreator = new BeanNameAutoProxyCreator();
        proxyCreator.setBeanNames("studentService");
        proxyCreator.setInterceptorNames("pointcutAdvisorImpl");
        return proxyCreator;
    }

    /**
     * 注入Advisor
     *
     * @return
     */
    @Bean
    public PointcutAdvisor pointcutAdvisorImpl() {
        return new PointcutAdvisorImpl();
    }

    @Bean
    public StudentService studentService() {
        return new StudentServiceImpl();
    }

}
