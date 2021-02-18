package spring.demo.factory;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.FactoryBean;
import spring.demo.model.Car;

/**
 * @author : Vander
 * @date :   2020/7/30
 * @description :
 */
@Setter
@Getter
public class CarFactoryBean implements FactoryBean<Car> {

    private String carInfo;

    @Override
    public Car getObject() throws Exception {
        return makeCarByCarInfo(carInfo);
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public static Car makeCarByCarInfo(String carInfo) {
        Car car = new Car();
        String[] infos = carInfo.split(",");
        car.setBrand(infos[0]);
        car.setMaxSpeed(Integer.valueOf(infos[1]));
        car.setPrice(Double.valueOf(infos[2]));
        return car;
    }
}
