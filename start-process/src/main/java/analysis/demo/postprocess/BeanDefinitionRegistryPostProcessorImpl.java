package analysis.demo.postprocess;

import analysis.demo.common.model.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author : Vander
 * @date :   2021/1/24
 * @description :
 */
@Component
public class BeanDefinitionRegistryPostProcessorImpl implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
        rootBeanDefinition.setBeanClass(Student.class);
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("stuId", "2010130110");
        propertyValues.add("stuName", "jason");
        rootBeanDefinition.setPropertyValues(propertyValues);
        registry.registerBeanDefinition("stu", rootBeanDefinition);
        System.err.println("BeanDefinitionRegistryPostProcessorImpl#postProcessBeanDefinitionRegistry : " + rootBeanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Student stu = (Student)beanFactory.getBean("stu");
        System.err.println("BeanDefinitionRegistryPostProcessorImpl#postProcessBeanFactory : " + stu);
    }
}
