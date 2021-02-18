package spring.demo.converter;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;
import spring.demo.factory.CarFactoryBean;
import spring.demo.model.Car;

import java.util.Collections;
import java.util.Set;

/**
 * @author : Vander
 * @date :   2020/10/27
 * @description : 此方式相对于PropertyEditor功能更强，能支持不同类型的转换
 */
public class StringToCarConverter implements ConditionalGenericConverter {
    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return sourceType.getType().equals(String.class) &&
                targetType.getType().equals(Car.class);
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(String.class, Car.class));
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Car car = CarFactoryBean.makeCarByCarInfo(source.toString());
        return car;
    }
}
