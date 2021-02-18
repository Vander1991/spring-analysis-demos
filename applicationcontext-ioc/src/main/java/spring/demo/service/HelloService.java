package spring.demo.service;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;

/**
 * @author : Vander
 * @date :   2020/10/22
 * @description :
 */
@Service
public class HelloService implements BeanNameAware {

    private String beanName;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    public void sayHello() {
        System.out.println(beanName + " say hello ! ");
    }

}
