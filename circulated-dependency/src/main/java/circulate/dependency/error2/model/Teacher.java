package circulate.dependency.error2.model;

import org.springframework.stereotype.Component;

/**
 * @author : Vander
 * @date :   2021/2/3
 * @description :
 */
@Component
public class Teacher {

    private Student student;

    public Teacher(Student student) {
        this.student = student;
    }

}
