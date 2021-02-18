package spring.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author : Vander
 * @date :   2020/7/30
 * @description :
 */
@Setter
@Getter
@ToString
public class Car {

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

}
