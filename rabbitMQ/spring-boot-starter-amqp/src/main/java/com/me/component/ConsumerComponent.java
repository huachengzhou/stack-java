package com.me.component;


import com.me.config.MQConfig;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 创建消费者监听器接收消息
 */
@Component
public class ConsumerComponent {
    private final Logger logger = LoggerFactory.getLogger(getClass());

//    @RabbitListener(queues = MQConfig.BOOT_TOPIC_QUEUE)
//    public void getMassage(Object massage){
//        logger.info("接收到消息："+massage);
//    }


    /**
     * 普通队列
     * @param msg
     * @param channel
     * @param message
     * @throws IOException
     */
    @RabbitListener(queues = MQConfig.BOOT_TOPIC_QUEUE)
    public void getMassage(String msg, Channel channel, Message message) throws IOException {
        System.out.println("接收到消息：" + msg);
        //手动ack
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }


    /**
     * 死信队列
     * @param msg
     * @param channel
     * @param message
     * @throws IOException
     */
    @RabbitListener(queues = MQConfig.QUEUE_TTL_WAITING)
    public void getMassageTTL(String msg, Channel channel, Message message) throws IOException {
        System.out.println("接收到消息：" + msg);
        //手动ack
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

    /**
     * 延迟队列
     * @param msg
     * @param channel
     * @param message
     * @throws IOException
     */
    @RabbitListener(queues = MQConfig.QUEUE_WAITING)
    public void getMassageWaiting(String msg, Channel channel, Message message) throws IOException {
        System.out.println("接收到消息：" + msg);
        //手动ack
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }




}
