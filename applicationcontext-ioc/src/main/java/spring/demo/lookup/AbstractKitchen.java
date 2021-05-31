package spring.demo.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;
import spring.demo.model.Refrigerator;

/**
 * @author : Vander
 * @date :   2021-05-28
 * @description : 此处的@Component必须加，因为首先是candidateComponent，才能到处理Lookup
 */
@Component
public abstract class AbstractKitchen {

    @Lookup
    public Refrigerator refrigerator() {
        return null;
    }

    public void printRefrigerator() {
        System.out.println(refrigerator());
    }
}
