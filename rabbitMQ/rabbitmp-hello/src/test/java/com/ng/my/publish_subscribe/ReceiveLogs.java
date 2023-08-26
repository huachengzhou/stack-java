package com.ng.my.publish_subscribe;

import com.my.common.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author : chengdu
 * @date :  2023/8/20-08
 **/
public class ReceiveLogs {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static final String EXCHANGE_NAME = "logs";

    @Test
    public void executeWork() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        /**
         * 生成一个临时的队列 队列的名称是随机的
         * 当消费者断开和该队列的连接时 队列自动删除
         */
        //创建一个具有随机名称的队列，或者， 甚至更好 - 让服务器为我们选择一个随机队列名称 (这也是为什么发布的时候压根没有指定  路由key)
        String queueName = channel.queueDeclare().getQueue();

        channel.queueBind(queueName, EXCHANGE_NAME, "");

        logger.info("queueName:" + queueName);

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };
        //队列名称,自动应答
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });

        TimeUnit.MINUTES.sleep(2);
        logger.info("end");
    }

}
