package spring.demo.customtag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author : Vander
 * @date :   2020/7/25
 * @description :
 */
public class MyNameSpaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("microwave", new MicrowaveBeanDefinitionParser());
    }
}
