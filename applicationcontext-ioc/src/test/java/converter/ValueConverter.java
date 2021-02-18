package converter;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import spring.demo.model.Car;

/**
 * @author : Vander
 * @date :   2020/10/26
 * @description :
 */
@Component
@Getter
public class ValueConverter {

    @Value("Mercedes-Benz,400,2000000")
    private Car car;

}
