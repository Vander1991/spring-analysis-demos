package spring.mybatis.simulate.annotation;

import org.springframework.context.annotation.Import;
import spring.mybatis.simulate.PandaMapperScannerRegistrar;

import java.lang.annotation.*;

/**
 * @author : Vander
 * @date :   2021/1/31
 * @description :
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(PandaMapperScannerRegistrar.class)
public @interface PandaMapperScan {

    String[] basePackages() default {};

}
