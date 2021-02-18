package infer.constructor.common.model;

import lombok.Data;

/**
 * @author : Vander
 * @date :   2021/1/27
 * @description :
 */
@Data
public class Teacher {

    private int teacherId;

    private String teacherName;

    private Student student;

    public Teacher() {
        System.out.println("Teacher()");
    }

    public Teacher(Student student) {
        System.out.println("Teacher(Student student)");
        this.student = student;
    }

    public Teacher(int teacherId, String teacherName) {
        System.out.println("Teacher(int teacherId, String teacherName)");
        this.teacherId = teacherId;
        this.teacherName = teacherName;
    }

    public Teacher(int teacherId, String teacherName, Student student) {
        System.out.println("Teacher(int teacherId, String teacherName, Student student)");
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.student = student;
    }
}
