package com.fangxp.myimpl;

import com.fangxp.demo.User;
import com.fangxp.demo.UserMapper;
import mybatisimpl.configuration.BdConfiguration;
import mybatisimpl.session.BdSqlSession;
import mybatisimpl.session.BdSqlSessionFactory;
import mybatisimpl.session.BdSqlSessionFactoryBuilder;

public class Test {

    public static void main(String[] args) {

        // 1. 读取配置文件
        BdConfiguration bdconfiguration = new BdConfiguration("mybatis-config.properties");

        //2. 构建SqlSessionFactory
        BdSqlSessionFactory sqlSessionFactory =
                new BdSqlSessionFactoryBuilder(bdconfiguration).build();
        System.out.println("111");
        BdSqlSession sqlSession = sqlSessionFactory.openSession();
        //namespace + id 需要修改namespace 测试
//        User o = (User)sqlSession.selectOne("com.fangxp.demo.User.findUserById", 1);
//        System.out.println(o);

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(1);
        System.out.println(user);


    }

}
