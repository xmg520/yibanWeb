package com.mxz.yiban.dao;


import com.mxz.yiban.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select * from user where id = #{id}")
    User findById(Integer id);

    @Select("select * from user where username = #{username} ")
    User findByName(String username);

    
}
