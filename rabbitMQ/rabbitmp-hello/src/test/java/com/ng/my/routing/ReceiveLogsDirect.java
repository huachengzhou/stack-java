package com.ng.my.routing;

import cn.hutool.json.JSONUtil;
import com.my.common.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * 消费者
 *
 * @author : chengdu
 * @date :  2023/8/20-08
 **/
public class ReceiveLogsDirect {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static final String EXCHANGE_NAME = "logDirect";

    @Test
    public void executeWork() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();

        //创建2个临时队列
        String queueOne = channel.queueDeclare().getQueue();
        String queueTwo = channel.queueDeclare().getQueue();

        //第一个队列 绑定一个路由key
        channel.queueBind(queueOne, EXCHANGE_NAME, "error");


        //第二个队列分别和三个路由路由key相绑定
        channel.queueBind(queueTwo, EXCHANGE_NAME, "info");
        channel.queueBind(queueTwo, EXCHANGE_NAME, "error");
        channel.queueBind(queueTwo, EXCHANGE_NAME, "warning");
        //丢掉debug消息
//        channel.queueBind(queueTwo, EXCHANGE_NAME, "debug");


        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            logger.info("consumerTag:" + consumerTag);
            logger.info("properties:" + JSONUtil.toJsonStr(delivery.getProperties()));
            logger.info("envelope:" + JSONUtil.toJsonStr(delivery.getEnvelope()));
            System.out.println(" 消息 '" + message + "'");
        };
        //队列名称,自动应答
        channel.basicConsume(queueOne, true, deliverCallback, consumerTag -> {
        });
        channel.basicConsume(queueTwo, true, deliverCallback, consumerTag -> {
        });

        TimeUnit.MINUTES.sleep(2);
        logger.info("end");
    }

}
