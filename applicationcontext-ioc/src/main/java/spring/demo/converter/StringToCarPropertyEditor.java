package spring.demo.converter;

import spring.demo.factory.CarFactoryBean;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

/**
 * @author : Vander
 * @date :   2020/10/26
 * @description :
 */
public class StringToCarPropertyEditor extends PropertyEditorSupport implements PropertyEditor {

    @Override
    public void setAsText(String carInfo) {
        this.setValue(CarFactoryBean.makeCarByCarInfo(carInfo));
    }

}
