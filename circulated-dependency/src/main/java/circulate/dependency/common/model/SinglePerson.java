package circulate.dependency.common.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Vander
 * @date :   2021/5/30
 * @description :
 */
@Component
public class SinglePerson {

    @Autowired
    private Wife2 wife2;
    // 此方法会被增强
    public void printWife2() {
        System.out.println("Single Person 's wife2 : " + wife2);
    }

}
