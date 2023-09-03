package com.me.test;

import com.me.RabbitMqApplication;
import com.me.config.MQConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class PAY_TTL_WAITING_JunitTest {


    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 整个队列的消息设置过期时间
     * @date 2022/3/24
     */
    @Test
   public void sendMessage() {
        rabbitTemplate.convertAndSend(
                MQConfig.EXCHANGE_TTL_WAITING,
                MQConfig.QUEUE_TTL_WAITING,
                "发送了TTL-WAITING-MESSAGE"+ UUID.randomUUID().toString());
        System.out.println("queue-ttl-ok = ");
    }

}
