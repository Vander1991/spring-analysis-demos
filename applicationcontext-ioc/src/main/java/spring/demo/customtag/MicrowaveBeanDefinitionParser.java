package spring.demo.customtag;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;
import spring.demo.model.Microwave;

/**
 * @author : Vander
 * @date :   2020/7/25
 * @description :
 */
public class MicrowaveBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class getBeanClass(Element element) {
        return Microwave.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder beanDefinitionBuilder) {
        String from = element.getAttribute("from");
        if(StringUtils.hasText(from)) {
            beanDefinitionBuilder.addPropertyValue("from", from);
        }
    }

}
