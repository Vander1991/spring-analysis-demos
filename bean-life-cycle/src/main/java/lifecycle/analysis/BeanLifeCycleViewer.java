package lifecycle.analysis;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author : Vander
 * @date :   2021-05-24
 * @description : 查看Bean的生命周期
 */
public class BeanLifeCycleViewer implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BeanLifeCycleViewer() {
        System.out.println("03. BeanLifeCycleViewer's constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("11. BeanLifeCycleViewer's init");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("16. BeanLifeCycleViewer's preDestroy");
    }

    /**
     * BeanFactoryAware
     *
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    /**
     * BeanNameAware
     *
     * @param name
     */
    @Override
    public void setBeanName(String name) {

    }

    /**
     * DisposableBean
     *
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {

    }

    /**
     * InitializingBean
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
