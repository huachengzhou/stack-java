package com.me.test;

import com.me.RabbitMqApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;


/**
 * @author noatn
 * @description
 * @date 2023-08-22
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RabbitMqApplication.class})
public class AMQPJunitTest {
    private final Logger logger = LoggerFactory.getLogger(getClass()) ;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
   public void contextLoads() throws IOException {
        rabbitTemplate.convertAndSend("boot-topic-exchange","ERROR","error");
        logger.info("sucess!");
    }


}
