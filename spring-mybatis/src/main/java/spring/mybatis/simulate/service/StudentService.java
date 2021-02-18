package spring.mybatis.simulate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.mybatis.simulate.mapper.StudentMapper;
import spring.mybatis.simulate.model.Student;

/**
 * @author : Vander
 * @date :   2021/1/31
 * @description :
 */
@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public Student selectById(int stuNo) {
        return studentMapper.selectById(stuNo);
    }

}
