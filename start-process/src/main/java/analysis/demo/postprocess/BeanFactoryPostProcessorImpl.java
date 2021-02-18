package analysis.demo.postprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author : Vander
 * @date :   2021/1/24
 * @description :
 */
@Component
public class BeanFactoryPostProcessorImpl implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition stu = beanFactory.getBeanDefinition("stu");
        System.err.println("BeanFactoryPostProcessorImpl#postProcessBeanFactory : " + stu);
    }
}
