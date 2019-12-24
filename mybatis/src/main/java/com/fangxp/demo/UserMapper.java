package com.fangxp.demo;


public interface UserMapper {

//    @Select("SELECT * FROM blog WHERE id = #{id}")
    User findUserById(int id);

}
