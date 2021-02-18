package spring.demo.config;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.support.DefaultConversionService;
import spring.demo.converter.StringToCarConverter;
import spring.demo.converter.StringToCarPropertyEditor;
import spring.demo.model.Car;

import java.beans.PropertyEditor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Vander
 * @date :   2020/10/26
 * @description :
 */
@Configuration
public class CustomEditorConfigurerConfig {

    /**
     * 方式一：仅仅支持将字符串转成其他类型
     *
     * @return
     */
    @Bean
    public CustomEditorConfigurer customEditorConfigurer() {
        CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
        Map<Class<?>, Class<? extends PropertyEditor>> propertyEditorMap = new HashMap<>();
        propertyEditorMap.put(Car.class, StringToCarPropertyEditor.class);
        customEditorConfigurer.setCustomEditors(propertyEditorMap);
        return customEditorConfigurer;
    }

    /**
     * 方式二：Spring自定义的ConversionService
     *
     * @return
     */
    @Bean
    public ConversionServiceFactoryBean conversionServiceFactoryBean() {
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
        conversionServiceFactoryBean.setConverters(Collections.singleton(new StringToCarConverter()));
        return conversionServiceFactoryBean;
    }

}
