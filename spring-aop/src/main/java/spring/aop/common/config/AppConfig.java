package spring.aop.common.config;

import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import spring.aop.common.advisor.PointcutAdvisorImpl;

/**
 * @author : Vander
 * @date :   2021/2/5
 * @description :
 */
@ComponentScan("spring.aop.common")
@EnableAspectJAutoProxy // 作用主要是注入AnnotationAwareAspectJAutoProxyCreator
public class AppConfig {

    @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
        BeanNameAutoProxyCreator proxyCreator = new BeanNameAutoProxyCreator();
        proxyCreator.setBeanNames("studentService");
        proxyCreator.setInterceptorNames("pointcutAdvisorImpl");
        return proxyCreator;
    }

    @Bean
    public PointcutAdvisor pointcutAdvisorImpl() {
        return new PointcutAdvisorImpl();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }

}
