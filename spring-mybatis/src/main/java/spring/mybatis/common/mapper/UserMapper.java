package spring.mybatis.common.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @author : Vander
 * @date :   2021/1/29
 * @description :
 */
public interface UserMapper {

    @Select("select 'test'")
    String selectById();

}
