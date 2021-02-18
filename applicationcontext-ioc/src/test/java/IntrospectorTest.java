import org.junit.Test;
import spring.demo.service.HelloService;

import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;

/**
 * @author : Vander
 * @date :   2020/11/9
 * @description :
 */
public class IntrospectorTest {

    @Test
    public void testGetBeanInfo() throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(HelloService.class);
        BeanDescriptor beanDescriptor = beanInfo.getBeanDescriptor();
        System.out.println(beanDescriptor);
    }

    @Test
    public void testDecapitalize() {
        String orderServiceName = Introspector.decapitalize("OrderService");
        System.out.println(orderServiceName);
    }

}
