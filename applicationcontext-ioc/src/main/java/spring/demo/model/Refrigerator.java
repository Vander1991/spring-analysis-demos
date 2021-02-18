package spring.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author : Vander
 * @date :   2020/7/24
 * @description :
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Refrigerator {
    private String no;

    public String getFood() {
        return "Chicken";
    }

}
