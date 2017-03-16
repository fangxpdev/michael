package com.fangxp.mq.consumer;


import com.fangxp.mq.constant.QueueConstant;
import com.fangxp.mq.dto.UserDTO;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class AdLogConsumer {

    private static final Logger logger = LoggerFactory.getLogger(AdLogConsumer.class);


    @JmsListener(destination = QueueConstant.AD_VISIT_LOG_QUEUE)
    public void onMessage(Object message) {
        try {
            if (message instanceof ActiveMQObjectMessage) {
                ActiveMQObjectMessage msg = (ActiveMQObjectMessage) message;
                Object o = msg.getObject();
                if(o instanceof UserDTO){
                    UserDTO dto = (UserDTO)o;
                    logger.info("consumer receive msg:{}",dto);
                }


            }
        } catch (JMSException e) {
            logger.error("JMS转换错误,消息信息：{},错误信息：", message, e);
        }
    }

}
