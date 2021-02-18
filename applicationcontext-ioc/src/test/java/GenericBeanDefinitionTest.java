import org.junit.Test;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.demo.model.Car;

/**
 * @author : Vander
 * @date :   2020/10/22
 * @description :
 */
public class GenericBeanDefinitionTest {

    @Test
    public void testAddGenericBeanDefinition() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(Car.class);
        context.registerBeanDefinition("car", beanDefinition);
        // 相当于将BeanDefinition中的Bean实例化（当然懒加载跟原型不会实例化）
        context.refresh();
        Car car = (Car)context.getBean("car");
        System.out.println(car);

    }

}
