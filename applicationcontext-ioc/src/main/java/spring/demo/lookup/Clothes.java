package spring.demo.lookup;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

/**
 * @author : Vander
 * @date :   2020/11/4
 * @description :
 */
@Component
@Scope(value = SCOPE_PROTOTYPE)
public class Clothes {

}
