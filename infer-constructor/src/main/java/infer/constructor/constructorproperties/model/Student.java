package infer.constructor.constructorproperties.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author : Vander
 * @date :   2021/1/27
 * @description :
 */
@Component("student")
@Data
public class Student {

    private int stuId;

    private String stuName;

    public Student() {
        System.out.println("Student()");
    }

    public Student(int stuId) {
        System.out.println("Student(int stuId)");
        this.stuId = stuId;
    }

    public Student(String stuName) {
        System.out.println("Student(String stuName)");
        this.stuName = stuName;
    }

    public Student(int stuId, String stuName) {
        System.out.println("Student(int stuId, String stuName)");
        this.stuId = stuId;
        this.stuName = stuName;
    }

}
