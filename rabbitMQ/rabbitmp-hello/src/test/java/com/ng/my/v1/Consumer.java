package com.ng.my.v1;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.rabbitmq.client.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author : chengdu
 * @date :  2023/8/13-08
 **/
public class Consumer {
    private final static String QUEUE_NAME = "hello";
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 简单消费者
     * @throws Exception
     */
    @Test
    public void acceptConsumer() throws Exception {
        //1:创建连接池
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("123456");
        Connection connection = connectionFactory.newConnection();

        //2:创建通道(数据交换通道)
        Channel channel = connection.createChannel();
        logger.info(DateUtil.now() +"等待接收消息....");

        //3:推送的消息如何进行消费的接口回调
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            logger.info("接收时间:"+DateUtil.now());
            //consumerTag 消费者标签，用来区分多个消费者
            logger.info("consumerTag:" + consumerTag);
            logger.info("properties:" + JSONUtil.toJsonStr(message.getProperties()));
            logger.info("envelope:" + JSONUtil.toJsonStr(message.getEnvelope()));
            logger.info("message:" + new String(message.getBody()));
            logger.info("");
        };
        //4:取消消费的一个回调接口 如在消费的时候队列被删除掉了
        CancelCallback cancelCallback = consumerTag -> {
            //consumerTag 消费者标签，用来区分多个消费者
            logger.info("consumerTag:" + consumerTag);
        };

        /**
         * 消费者消费消息
         * 1.消费哪个队列
         * 2.消费成功之后是否要自动应答 true 代表自动应答 false 手动应答
         * 3.消费者未成功消费的回调
         */
        channel.basicConsume(QUEUE_NAME,true,deliverCallback,cancelCallback) ;
        TimeUnit.MINUTES.sleep(2);
    }

}
