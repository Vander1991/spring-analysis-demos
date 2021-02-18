package spring.demo.autowire;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.demo.model.Fan;

import javax.annotation.Resource;

/**
 * @author : Vander
 * @date :   2020/11/4
 * @description :
 */
@Component
@Getter
public class Classroom {

    @Autowired
    @Resource
    private AirConditioner airConditioner;

    @Autowired
    private Fan fan;

    public Classroom(@Autowired AirConditioner airConditioner) {
        System.out.println("构造方法注入：" + airConditioner);
    }

//    @Autowired
//    public Fan fan(Fan fan) {
//        System.out.println("属性注入：" + fan);
//        return fan;
//    }

    public AirConditioner getAirConditioner() {
        System.out.println(airConditioner);
        return airConditioner;
    }

}
