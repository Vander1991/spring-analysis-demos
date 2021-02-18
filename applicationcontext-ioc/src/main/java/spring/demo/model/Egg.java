package spring.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author : Vander
 * @date :   2020/8/5
 * @description :
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Egg {

    private String eggName;

    private Chicken chicken;

}
