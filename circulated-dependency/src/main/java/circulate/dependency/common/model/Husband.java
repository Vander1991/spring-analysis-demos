package circulate.dependency.common.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Vander
 * @date :   2021/2/1
 * @description :
 */
@Getter
@Setter
@Component
public class Husband {

    @Autowired
    private Wife wife;

    @Autowired
    private Wife2 wife2;

    public void makeMoney() {
        System.out.println("makeMoney");
    }

    public void printMyWife() {
        System.out.println(this.toString() + "'s " + wife);
    }

}
