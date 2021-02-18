package spring.mybatis.simulate.mapper;

import spring.mybatis.simulate.model.Student;

/**
 * @author : Vander
 * @date :   2021/1/31
 * @description :
 */
public interface StudentMapper {

    Student selectById(int stuNo);

}
