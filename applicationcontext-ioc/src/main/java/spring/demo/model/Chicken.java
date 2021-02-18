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
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Chicken {

    private String chickenName;

    private Egg egg;

}
