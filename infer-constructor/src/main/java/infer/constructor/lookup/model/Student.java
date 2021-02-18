package infer.constructor.lookup.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

/**
 * @author : Vander
 * @date :   2021/1/27
 * @description :
 */
@Component
@Scope(value = SCOPE_PROTOTYPE)
public class Student {
    public Student() {
    }
}
