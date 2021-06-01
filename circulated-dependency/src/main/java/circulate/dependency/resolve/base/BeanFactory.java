package circulate.dependency.resolve.base;

/**
 * @author : Vander
 * @date :   2021/5/29
 * @description :
 */
public interface BeanFactory {

    Object getBean(String beanName);

    <T> T getBean(String beanName, Class<T> requiredType);

}
