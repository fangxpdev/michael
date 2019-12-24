package com.fangxp.aop;

import com.fangxp.WebApplication;
import com.fangxp.aop.service.TestService;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by michael on 2017/3/16.application.yml
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AopTest {

    @Autowired
    TestService testService;

    @org.junit.Test
    public void tst() throws Throwable{
//        TestService test = new TestService();
        testService.insert("micheal");
//        testService.save("222","sans");

    }
}
