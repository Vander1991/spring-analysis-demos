package spring.demo.value;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import spring.demo.model.Fan;

/**
 * @author : Vander
 * @date :   2020/11/4
 * @description :
 */
@Component
@Getter
public class Classroom {

    @Value("#{fan}")
    private Fan fan;

}
