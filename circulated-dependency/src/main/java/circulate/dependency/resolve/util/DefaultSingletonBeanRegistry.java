package circulate.dependency.resolve.util;

import lombok.Getter;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.BeanDefinition;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : Vander
 * @date :   2021/5/29
 * @description :
 */
@Getter
public class DefaultSingletonBeanRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
    /**
     * 一级缓存，经历了完整周期的Bean
     */
    protected final Map<String, Object> singletonObjects = new ConcurrentHashMap<>();
    /**
     * 二级缓存，存放提前增强过的Bean
     */
    protected final Map<String, Object> earlySingletonObjects = new HashMap<>();
    /**
     * 三级缓存，存放AOP的Lambda
     */
    protected final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>();
    /**
     * 存放当前正在创建的beanName
     */
    protected final Set<String> singletonsCurrentlyInCreation =
            Collections.newSetFromMap(new ConcurrentHashMap<>());

    /**
     * 模拟Spring注册BeanDefinition
     *
     * @param beanDefinition
     */
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    /**
     * 负责调起ObjectFactory，并在其前后记录创建状态
     *
     * @param beanName
     * @param singletonFactory
     * @return
     */
    public Object getSingleton(String beanName, ObjectFactory<?> singletonFactory) {
        Object singletonObject = this.singletonObjects.get(beanName);
        boolean newSingleton = false;
        beforeSingletonCreation(beanName); // 记录beanName正在创建中
        if (singletonObject == null) {
            try {
                singletonObject = singletonFactory.getObject();// -_核心_- 初始化Bean
                newSingleton = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (newSingleton) {
                addSingleton(beanName, singletonObject);// 加入缓存
            }
        }
        afterSingletonCreation(beanName); // 记录beanName已创建完毕
        return singletonObject;
    }

    /**
     * 添加经历完完整生命周期的Bean到单例池
     *
     * @param beanName
     * @param singletonObject
     */
    protected void addSingleton(String beanName, Object singletonObject) {
        synchronized (this.singletonObjects) {
            // 添加到一级缓存
            this.singletonObjects.put(beanName, singletonObject);
            // beanName->ObjectFactory的对应关系 从三级缓存中移除
            this.singletonFactories.remove(beanName);
            // 当bean还在创建过程中会放入此缓存  从二级缓存中移除
            this.earlySingletonObjects.remove(beanName);
        }
    }

    /**
     * 记录当前正在创建
     *
     * @param beanName
     */
    protected void beforeSingletonCreation(String beanName) {
        if (!this.singletonsCurrentlyInCreation.add(beanName)) {
            throw new BeanCurrentlyInCreationException(beanName);
        }
    }

    /**
     * 记录当前已创建完毕
     *
     * @param beanName
     */
    protected void afterSingletonCreation(String beanName) {
        if (!this.singletonsCurrentlyInCreation.remove(beanName)) {
            throw new IllegalStateException("Singleton '" + beanName + "' isn't currently in creation");
        }
    }
}
