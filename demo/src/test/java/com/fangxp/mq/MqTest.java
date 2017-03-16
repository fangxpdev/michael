package com.fangxp.mq;

import com.fangxp.WebApplication;
import com.fangxp.mq.component.ActiveMqPublisherHelper;
import com.fangxp.mq.dto.UserDTO;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Queue;

/**
 * Created by michael on 2017/3/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MqTest {

    @Autowired
    ActiveMqPublisherHelper helper;

    @Autowired
    Queue adVisitLogQueue;

    @Test
    public void test() {
        UserDTO dto = new UserDTO(1,"micheal");
        helper.convertAndSendAsync(adVisitLogQueue,dto);
    }
}
