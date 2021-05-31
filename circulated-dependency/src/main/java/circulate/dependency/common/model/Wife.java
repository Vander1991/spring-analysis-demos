package circulate.dependency.common.model;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Vander
 * @date :   2021/2/1
 * @description :
 */
@Setter
@Component
public class Wife {

    @Autowired
    private Husband husband;

    public void makeUp() {
        System.out.println("makeUp");
    }

    public Husband getHusband() {
        return husband;
    }

    public void printMyHusband() {
        System.out.println(this.toString() + "'s " + husband);
    }

}
