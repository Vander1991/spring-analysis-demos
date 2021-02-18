import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.demo.model.Microwave;

/**
 * @author : Vander
 * @date :   2020/10/22
 * @description :
 */
public class XmlBeanDefinitionReaderTest {

    @Test
    public void testLoadBeanDefinitions() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 传入BeanDefinitionRegistry作为构造参数
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        // 读取Xml并生成BeanDefinition
        xmlBeanDefinitionReader.loadBeanDefinitions("beandefinition-simple.xml");
        // 生成Bean
        applicationContext.refresh();
        // 从容器中取出Bean
        Microwave microwave = (Microwave) applicationContext.getBean("microwave");
        System.out.println(microwave);
    }

}
