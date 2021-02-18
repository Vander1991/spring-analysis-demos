package spring.demo.postprocess;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author : Vander
 * @date :   2020/7/30
 * @description :
 */
@Setter
@Getter
@ToString
@Component
public class Car implements InitializingBean {

    public Car() {
        System.out.println("构造 Car");
    }

    public Car(String brand, int maxSpeed, double price) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
        this.price = price;
        System.out.println("构造 Car");
    }

    private String brand;

    private int maxSpeed;

    private double price;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet: Car 的初始化");
    }

}
