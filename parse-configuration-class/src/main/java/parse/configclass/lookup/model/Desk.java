package parse.configclass.lookup.model;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * @author : Vander
 * @date :   2021/1/25
 * @description :
 */
@Component
public abstract class Desk {

    @Lookup
    public Chair chair() {
        return new Chair();
    }

}
