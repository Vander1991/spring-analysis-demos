package spring.demo.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

/**
 * @author : Vander
 * @date :   2020/11/4
 * @description : Spring提供了一个名为@Lookup的注解，这是一个作用在方法上的注解，被其标注的方法会被重写，然后根据其返回值的类型，
 *              容器调用BeanFactory的getBean()方法来返回一个bean。
 */
@Service
public class Employee {

    @Autowired// 依赖注入时只会注入一个
    private Clothes clothes;

    public void takeClothes() {
        System.out.println(this + " take " + clothes);
    }

    public void takeClothes2() {
        System.out.println(this + " take " + getClothes());
    }

    /**
     * 每次都从容器中拿Bean出来
     *
     * @return
     */
    @Lookup
    public Clothes getClothes() {
        return null;
    }

}
