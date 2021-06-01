package circulate.dependency.resolve;

import circulate.dependency.common.model.Husband;
import circulate.dependency.common.model.SinglePerson;
import circulate.dependency.common.model.Wife;
import circulate.dependency.common.model.Wife2;
import circulate.dependency.resolve.base.BeanFactory;
import circulate.dependency.resolve.step3.SimpleBeanFactory3;
import circulate.dependency.resolve.util.BeanDefinitionReader;
import circulate.dependency.resolve.util.DefaultSingletonBeanRegistry;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * @author : Vander
 * @date :   2021/5/29
 * @description :
 */
public class Main {

    public static void main(String[] args){
        BeanDefinitionReader beanDefinitionReader = new BeanDefinitionReader();
        BeanDefinition husbandBeanDefinition = beanDefinitionReader.loadBeanDefinition(Husband.class);
        BeanDefinition wifeBeanDefinition = beanDefinitionReader.loadBeanDefinition(Wife.class);
        BeanDefinition wife2BeanDefinition = beanDefinitionReader.loadBeanDefinition(Wife2.class);
        BeanDefinition singlePersonBeanDefinition = beanDefinitionReader.loadBeanDefinition(SinglePerson.class);

        BeanFactory beanFactory = new SimpleBeanFactory3();
        ((DefaultSingletonBeanRegistry)beanFactory).registerBeanDefinition("husband", husbandBeanDefinition);
        ((DefaultSingletonBeanRegistry)beanFactory).registerBeanDefinition("wife", wifeBeanDefinition);
        ((DefaultSingletonBeanRegistry)beanFactory).registerBeanDefinition("wife2", wife2BeanDefinition);
        ((DefaultSingletonBeanRegistry)beanFactory).registerBeanDefinition("singlePerson", singlePersonBeanDefinition);

        Husband husband = beanFactory.getBean("husband", Husband.class);
        husband.makeMoney();
        Wife wifeOfHusband = husband.getWife();
        Wife2 wife2OfHusband = husband.getWife2();
        Wife wife = beanFactory.getBean("wife", Wife.class);
        System.out.println("Husband's wife : " + wifeOfHusband);
        System.out.println("          wife : " + wife);
        Wife2 wife2 = beanFactory.getBean("wife2", Wife2.class);
        System.out.println("Husband's wife2 : " + wife2OfHusband);
        System.out.println("          wife2 : " + wife2);

        // 没有循环依赖的Bean，但是有AOP增强
        SinglePerson singlePerson = beanFactory.getBean("singlePerson", SinglePerson.class);
        singlePerson.printWife2();
    }

}
