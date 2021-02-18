package spring.demo.listener;

import org.springframework.beans.factory.parsing.*;

/**
 * @author : Vander
 * @date :   2020/7/25
 * @description :
 */
public class BeanRegistryEventListener implements ReaderEventListener {
    @Override
    public void defaultsRegistered(DefaultsDefinition defaultsDefinition) {

    }

    @Override
    public void componentRegistered(ComponentDefinition componentDefinition) {
        componentDefinition.getInnerBeanDefinitions();
    }

    @Override
    public void aliasRegistered(AliasDefinition aliasDefinition) {

    }

    @Override
    public void importProcessed(ImportDefinition importDefinition) {

    }
}
