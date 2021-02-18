package analysis.test;

import analysis.demo.common.config.AppConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : Vander
 * @date :   2021/1/23
 * @description :
 */
public class AnnotationConfigApplicationContextTest {

    @Test
    public void testStartProcess() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    /**
     * 发现setApplicationContext会被执行两次，一次是由于实现Aware接口，在实例化前被回调一次
     * 另一次是由于@Autowired注解又被执行了一次
     */
    @Test
    public void testAware1() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("analysis.demo.aware");
        applicationContext.refresh();
    }

    /**
     * 发现就算ApplicationContextAwareDemo不实现Aware接口，会调用setFan方法一次（由于使用了ByName或ByType）
     * 而实现了ApplicationContextAware接口后，setApplicationContext不会因为ByName再被调用一次，也是被调用一次的原因
     * 是ByName会筛掉实现了一系列Aware接口，不去重复调用对应的set方法（是由于在refresh时往BeanFactory中设置了ignoreDependencyInterface
     */
    @Test
    public void testAware2() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-autowiremode.xml");
    }

}
