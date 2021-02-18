package spring.demo.factory;

import spring.demo.model.Refrigerator;

/**
 * @author : Vander
 * @date :   2020/7/24
 * @description :
 */
public class RefrigeratorFactory {

    public Refrigerator produce() {
        return new Refrigerator("000");
    }

}
