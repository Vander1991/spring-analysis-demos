package infer.constructor.constructorproperties.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Vander
 * @date :   2021/1/27
 * @description :
 */
@Data
@Component
public class Teacher {

    private int teacherId;

    private String teacherName;

    private List<Student> students = new ArrayList<>();

    public Teacher() {
        System.out.println("Teacher()");
    }

    @ConstructorProperties({"jason", "winnie"})
    public Teacher(Student jason, Student winnie) {
        System.out.println("(Student student1, Student student2)");
        students.add(jason);
        students.add(winnie);
    }

    public Teacher(int teacherId, String teacherName) {
        System.out.println("Teacher(int teacherId, String teacherName)");
        this.teacherId = teacherId;
        this.teacherName = teacherName;
    }

    public Teacher(int teacherId, String teacherName, List<Student> students) {
        System.out.println("Teacher(int teacherId, String teacherName, Student student)");
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.students = students;
    }
}
