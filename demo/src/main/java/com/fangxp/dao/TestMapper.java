package com.fangxp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

/**
 * Created by michael on 2017/3/16.
 */
@Mapper
public interface TestMapper {

    @Select("select name from orders")
//    @ResultType(String.class)
    public String testSelect();

}
