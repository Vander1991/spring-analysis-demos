package circulate.dependency.common.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Vander
 * @date :   2021/2/1
 * @description :
 */
@Component
public class Husband {

//    @Autowired
//    private Wife wife;

    public void makeMoney() {
        System.out.println("makeMoney");
    }

}
