package com.ng.my.dead;

import com.my.common.RabbitMqUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author : chengdu
 * @date :  2023/9/3-09
 **/
public class Producer {

    private static final String NORMAL_EXCHANGE = "normal_exchange";
    private static final String QUEUE_NAME = "normal_exchange_test2";
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void test2()throws Exception{
        Channel channel = RabbitMqUtils.getChannel();
        logger.info("start");
        // 创建一个交换机，不创建也可以，直接使用默认的
        channel.exchangeDeclare("direct1", BuiltinExchangeType.DIRECT);
        // 创建队列
        channel.queueDeclare(QUEUE_NAME, false, false, true, null);
        // 绑定队列和交换机
        channel.queueBind(QUEUE_NAME,"direct1",QUEUE_NAME);
        // 设置消息属性BasicProperties中的expiration
        AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
        builder.expiration("10000");
        String msg ="ttl--shshsd" ;
        for (int i = 0; i < 10; i++) {
            System.out.println(msg + i);
            channel.basicPublish("direct1", QUEUE_NAME, builder.build(), (msg + i).getBytes());
        }

//        TimeUnit.MINUTES.sleep(2);
        logger.info("end");
    }

    @Test
    public void acceptProducer() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        logger.info("start");
        //设置消息的 TTL 时间
        AMQP.BasicProperties properties = new
                AMQP.BasicProperties().builder().expiration("10000").build();
        //该信息是用作演示队列个数限制
        for (int i = 1; i < 11; i++) {
            String message = "info" + i;
            channel.basicPublish(NORMAL_EXCHANGE, "zhangsan", properties,
                    message.getBytes());
            System.out.println("生产者发送消息:" + message);
        }
        TimeUnit.MINUTES.sleep(2);
        logger.info("end");
    }
}
