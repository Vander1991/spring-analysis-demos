package parse.configclass.importannotation.model;

import org.springframework.stereotype.Component;

/**
 * @author : Vander
 * @date :   2021/1/26
 * @description : 由于此类是Import进来的所以不属于配置类对应的BD，所以若有beanMethod为student的话，没法将此Bean覆盖
 */
@Component("student")
public class Student {
}
