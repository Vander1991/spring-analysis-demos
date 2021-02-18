package spring.demo.autowire.inherit;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : Vander
 * @date :   2020/11/19
 * @description :
 */
public class Refrigerator {

    @Autowired
    private Hamburger hamburger;

    public Hamburger getHamburger() {
        return hamburger;
    }

}
