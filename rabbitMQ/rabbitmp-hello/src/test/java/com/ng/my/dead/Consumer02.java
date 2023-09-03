package com.ng.my.dead;

import com.my.common.RabbitMqUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author : chengdu
 * @date :  2023/9/3-09
 **/
public class Consumer02 {
    private static final String DEAD_EXCHANGE = "dead_exchange";
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void oneWork() throws Exception{
        Channel channel = RabbitMqUtils.getChannel();
        logger.info("start");
        channel.exchangeDeclare(DEAD_EXCHANGE, BuiltinExchangeType.DIRECT);
        String deadQueue = "dead-queue";
        channel.queueDeclare(deadQueue, false, false, false, null);
        channel.queueBind(deadQueue, DEAD_EXCHANGE, "lisi");
        System.out.println("等待接收死信队列消息.....");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("Consumer02 接收死信队列的消息" + message);
        };
        channel.basicConsume(deadQueue, true, deliverCallback, consumerTag -> {
        });


        TimeUnit.MINUTES.sleep(2);
        logger.info("end");
    }
}
