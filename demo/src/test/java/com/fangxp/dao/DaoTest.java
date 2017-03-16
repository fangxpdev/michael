package com.fangxp.dao;

import com.fangxp.WebApplication;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by michael on 2017/3/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DaoTest {

    @Autowired
    TestMapper mapper;

    @Test
    public void test() {
        System.out.println(mapper.testSelect());
    }

}
