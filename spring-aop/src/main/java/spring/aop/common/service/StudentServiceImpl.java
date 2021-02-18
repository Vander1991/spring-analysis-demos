package spring.aop.common.service;

import lombok.Getter;
import lombok.Setter;
import spring.aop.common.model.Student;

/**
 * @author : Vander
 * @date :   2021/2/3
 * @description :
 */
@Setter
@Getter
public class StudentServiceImpl implements StudentService {

    @Override
    public void doSomeSports(Student student) {
        System.out.println(student.toString() + " do some sports");
    }

    @Override
    public String examine(Student student) {
        return student.toString() + " examining";
    }
}
