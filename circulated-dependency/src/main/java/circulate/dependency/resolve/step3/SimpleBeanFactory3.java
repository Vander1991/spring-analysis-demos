package circulate.dependency.resolve.step3;

import circulate.dependency.resolve.base.BeanFactory;
import circulate.dependency.resolve.util.AutowiredAnnotationBeanUtil;
import circulate.dependency.resolve.util.DefaultSingletonBeanRegistry;
import circulate.dependency.resolve.util.JdkProxyBeanPostProcessor;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * @author : Vander
 * @date :   2021/5/29
 * @description :
 */
public class SimpleBeanFactory3 extends DefaultSingletonBeanRegistry implements BeanFactory {

    private AutowiredAnnotationBeanUtil autowiredAnnotationBeanUtil = new AutowiredAnnotationBeanUtil(this);

    @Override
    public Object getBean(String beanName) {//org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean
        Object instance = null;
        try {
            // 先从缓存中获取
            // husband依赖于wife，填充wife属性时，创建wife，填充wife的husband属性，调用getBean到此处，此时会提前将三级缓存取出提前AOP
            // 如果没有循环依赖，则会在初始化后进行AOP
            instance = getSingleton(beanName);
            if (null != instance) {
                return instance;
            }

            // 实例化、属性填充、初始化
            instance = getSingleton(beanName, () -> {// singleton的创建
                try {
                    return createBean(beanName);// -_核心_- 实例化、属性填充、初始化
                }
                catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }

    @Override
    public <T> T getBean(String beanName, Class<T> requiredType) {
        Object bean = getBean(beanName);
        if (requiredType != null && requiredType.isInstance(bean)) {
            return (T) bean;
        }
        return null;
    }

    /**
     * 按顺序，从1/2/3级缓存中取出，三级缓存中有，则运行
     *
     * @param beanName
     * @return
     */
    private Object getSingleton(String beanName) {
        // 从（单例池）一级缓存中获取bean，此处的bean是完整走完生命周期的
        Object singletonObject = this.singletonObjects.get(beanName);
        // 当前bean处在创建中，说明是循环依赖的情况
        if (singletonObject == null && isSingletonCurrentlyInCreation(beanName)) {
            synchronized (this.singletonObjects) {
                // 查看二级缓存中是否存在该bean，若存在说明已经被增强过的，但是没走完整个生命周期
                singletonObject = this.earlySingletonObjects.get(beanName);
                // 在husband bean创建发现需要先创建wife属性，wife bean创建又发现需要husband属性时，husband此时会在三级缓存中
                if (singletonObject == null) {
                    // 从三级缓存中获取原始bean对应的ObjectFactory
                    ObjectFactory<?> singletonFactory = this.singletonFactories.get(beanName);
                    if (singletonFactory != null) {
                        // 调用预先设定的getObject()，会调用getEarlyBeanReference
                        // 此方法会SmartInstantiationAwareBeanPostProcessor#getEarlyBeanReference判断是否需要生成代理类
                        singletonObject = singletonFactory.getObject();
                        // 记录在二级缓存中，说明还没经历过完整的生命周期 二三级缓存用的HashMap，两个map会一起操作，所以要直接加锁，
                        // 所以没必要用concurrentHashMap
                        this.earlySingletonObjects.put(beanName, singletonObject);
                        // 从三级缓存中移除，earlySingletonObjects和singletonFactories互斥
                        this.singletonFactories.remove(beanName);
                    }
                }
            }
        }
        return singletonObject;
    }

    public Object createBean(String beanName) throws Exception {
        return doCreateBean(beanName);// 实例化、放入三级缓存Lambda、填充属性
    }

    /**
     * 核心逻辑，完成实例化、属性填充、AOP
     *
     * @param beanName
     * @return
     * @throws Exception
     */
    public Object doCreateBean(String beanName) throws Exception {
        Object bean = createBeanInstance(beanName);
        // 一开始创建时，就将bean是否增强的逻辑放入到Lambda，Lambda放入三级缓存中
        addSingletonFactory(beanName, () -> getEarlyBeanReference(beanName, bean));

        Object exposedObject = bean;
        populateBean(beanName, bean);

        // 没有产生循环依赖的情况下，会在此处进行AOP
        Object earlySingletonReference = getSingleton(beanName);

        // 检测到循环依赖的情况下才不为空
        if (earlySingletonReference != null) {
            // 若exposedObject没有在初始化方法中被改变
            if (exposedObject == bean) {
                exposedObject = earlySingletonReference;
            }
        }
        return exposedObject;
    }

    /**
     * 填充属性
     *
     * @param beanName
     * @param bean
     */
    private void populateBean(String beanName, Object bean) {
        // 属性填充
        autowiredAnnotationBeanUtil.fillAttribute(bean);
    }

    /**
     * 添加Lambda到三级缓存
     *
     * @param beanName
     * @param singletonFactory
     */
    private void addSingletonFactory(String beanName, ObjectFactory<?> singletonFactory) {
        this.singletonFactories.put(beanName, singletonFactory);
    }

    /**
     * 判断是否需要进行AOP增强
     *
     * @param beanName
     * @param bean
     * @return
     */
    private Object getEarlyBeanReference(String beanName, Object bean) {
        // AOP增强，增强后，注解信息会丢失
        Object earlyBeanReference = new JdkProxyBeanPostProcessor().getEarlyBeanReference(bean, beanName);
        // 执行完三级缓存中的lambda结果放入二级缓存
        earlySingletonObjects.put(beanName, earlyBeanReference);
        return earlyBeanReference;
    }

    /**
     * 反射调用创建bean实例
     *
     * @param beanName
     * @return
     * @throws Exception
     */
    private Object createBeanInstance(String beanName) throws Exception {
        BeanDefinition beanDefinition = super.getBeanDefinitionMap().get(beanName);
        Class<?> beanClass = Class.forName(beanDefinition.getBeanClassName());
        Object instance = beanClass.newInstance();
        return instance;
    }

    /**
     * 判断Bean是否处于创建当中
     *
     * @param beanName
     * @return
     */
    public boolean isSingletonCurrentlyInCreation(String beanName) {
        return this.singletonsCurrentlyInCreation.contains(beanName);
    }

}
