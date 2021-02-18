package parse.configclass.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
import parse.configclass.factorybean.model.Student;

/**
 * @author : Vander
 * @date :   2021/1/27
 * @description :
 */
@Component("student")
public class FactoryBeanImpl implements FactoryBean<Student> {
    @Override
    public Student getObject() throws Exception {
        return new Student();
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }
}
