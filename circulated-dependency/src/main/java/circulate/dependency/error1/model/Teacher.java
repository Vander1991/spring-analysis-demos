package circulate.dependency.error1.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author : Vander
 * @date :   2021/2/3
 * @description :
 */
@Scope("prototype")
@Component
public class Teacher {

    @Autowired
    private Student student;

}
