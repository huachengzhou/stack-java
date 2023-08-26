package com.ng.my.publisher_confirms;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.my.common.RabbitMqUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ProducerOrConsumerOneConfirm {
    public static int MESSAGE_COUNT = 50;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static String QUEUE_NAME = "ee12816f-89e1-415c-a75a-5adf3980a9fc";

    /**
     * 消费 MESSAGE_COUNT 个
     *
     * @throws Exception
     */
    @Test
    public void consumerWork() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();

        int prefetchCount = 1;
        //只处理一个
        channel.basicQos(prefetchCount);


        logger.info(DateUtil.now() + "等待接收消息....");

        //3:推送的消息如何进行消费的接口回调
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            logger.info("接收时间:" + DateUtil.now());
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
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
        TimeUnit.MINUTES.sleep(2);
        logger.info("end");
    }


    /**
     * 单个确认
     * 总共50个
     */
    @Test
    public void oneConfirm() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        String queueName = UUID.randomUUID().toString();
        logger.info("queue:" + queueName);
        channel.queueDeclare(queueName, false, false, true, null);
        //开启发布确认
        channel.confirmSelect();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String message = RandomUtil.randomNumbers(20);
            channel.basicPublish("", queueName, null, message.getBytes());
            //服务端返回 false 或超时时间内未返回，生产者可以消息重发
            boolean flag = channel.waitForConfirms();
            if (flag) {
                System.out.println("消息发送成功");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("发布" + MESSAGE_COUNT + "个单独确认消息,耗时" + (end - begin) + "ms");

        TimeUnit.MINUTES.sleep(2);
        logger.info("end");
    }

}
