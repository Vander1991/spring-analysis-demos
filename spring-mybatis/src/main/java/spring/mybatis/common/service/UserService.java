package spring.mybatis.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.mybatis.common.mapper.UserMapper;

/**
 * @author : Vander
 * @date :   2021/1/29
 * @description :
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void selectById() {
        userMapper.selectById();
    }

}
