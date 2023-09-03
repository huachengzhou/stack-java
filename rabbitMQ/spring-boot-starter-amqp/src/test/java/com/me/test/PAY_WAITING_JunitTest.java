package com.me.test;

import com.me.RabbitMqApplication;
import com.me.config.MQConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * @author : chengdu
 * @date :  2023/9/3-09
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RabbitMqApplication.class})
public class PAY_WAITING_JunitTest {


    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 整个队列的消息设置过期时间
     *
     * @date 2022/3/24
     */
    @Test
    public void sendMessage() throws Exception {
        MessageProperties properties = new MessageProperties();
        properties.setExpiration("5000");
        String s = "发送了WAITING-MESSAGE"+UUID.randomUUID().toString();
        Message message = new Message(s.getBytes("utf-8"), properties);

        rabbitTemplate.convertAndSend(
                MQConfig.EXCHANGE_WAITING,
                MQConfig.QUEUE_WAITING,
                message);

        System.out.println("queue-wait-ok = ");
    }

}
