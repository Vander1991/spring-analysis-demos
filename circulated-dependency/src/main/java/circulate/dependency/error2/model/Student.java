package circulate.dependency.error2.model;

import org.springframework.stereotype.Component;

/**
 * @author : Vander
 * @date :   2021/2/3
 * @description : 构造方法注入，是因为还没走到放入三级缓存的逻辑（构造方法上加上懒加载能解决，因为构造方法刚开始注入的是代理对象，等
 *  真实用这个bean的时候，才会去创建）
 */
@Component
public class Student {

    private Teacher teacher;

    public Student(Teacher teacher) {
        this.teacher = teacher;
    }

}
