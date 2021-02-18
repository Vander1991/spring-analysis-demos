import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import spring.demo.factory.AbstractCarFactory;
import spring.demo.model.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import static org.junit.Assert.assertEquals;

/**
 * @author : Vander
 * @date :   2020/7/16
 * @description :
 */
@SuppressWarnings("deprecation")
public class BeanFactoryTest {

    @Test
    public void testSimpleLoad() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beandefinition-context.xml"));

        Microwave microwave = (Microwave) beanFactory.getBean("microwave");
        assertEquals("China", microwave.getFrom());
    }

    @Test
    public void testCircular() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beandefinition-circular.xml"));
//        ((XmlBeanFactory) beanFactory).addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
//            public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) {
//                if (beanName.equals("egg_0")) {
//                    return new Chicken();
//                } else {
//                    return null;
//                }
//            }
//        });
        System.out.println(beanFactory.getBean("egg_0"));
    }

    @Test
    public void testMethodOverride() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beandefinition-context.xml"));
        AbstractCarFactory carFactory = (AbstractCarFactory) beanFactory.getBean("carFactory");
        System.out.println(carFactory.getCar());

        Refrigerator refrigerator = (Refrigerator) beanFactory.getBean("refrigerator_0");
        refrigerator.getFood();
    }

    @Test
    public void testFactoryBean() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beandefinition-factorybean.xml"));

        Car car = (Car) beanFactory.getBean("car");// 调用AbstractBeanFactory的getBean方法

        System.out.println(car);// 获取CarFactoryBean.getObject方法返回的Bean

        System.out.println(beanFactory.getBean("&car"));// 获取CarFactoryBean
    }

    @Test
    public void testSimpleGetBean() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beandefinition-simple.xml"));

        Microwave microwave = (Microwave) beanFactory.getBean("microwave");// 调用AbstractBeanFactory的getBean方法
        assertEquals("Africa", microwave.getFrom());
    }

    @Test
    public void testAlias() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beandefinition-alias.xml"));

        Microwave microwave = (Microwave) beanFactory.getBean("defaultMicroWave");// 调用AbstractBeanFactory的getBean方法
        assertEquals("China", microwave.getFrom());
    }


    @Test
    public void testCustomSimpleLoad() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("custom-beandefinition.xml"));

        Microwave microwave = (Microwave) beanFactory.getBean("microwave_x");
        assertEquals("Africa", microwave.getFrom());
    }

    @Test
    public void testLoadDom() throws Exception {
        Resource resource = new ClassPathResource("custom-beandefinition.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(false);
        factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
        InputSource inputSource = new InputSource(resource.getInputStream());
        inputSource.setEncoding("utf-8");
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document document = docBuilder.parse(inputSource);
        Element documentElement = document.getDocumentElement();
        String namespaceURI = documentElement.getNamespaceURI();// 对同个文件进行加载，竟然没看到namespaceURI
        System.out.println(namespaceURI);
    }

}
