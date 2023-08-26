package com.ng.my.qos;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.my.common.RabbitMqUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class NewQosWorker {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static final String TASK_QUEUE_NAME = "task_qos_queue";


    @Test
    public void oneWork() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        int prefetchCount = 1;
//        int prefetchCount = 5;//prefetchCount，这个值设置为5时，表示当前通道内，最多只有5条进来，再多就在外面排队
        // 不公平分发
        channel.basicQos(prefetchCount);
        logger.info(DateUtil.now() + "等待接收消息....");
        extracted(channel, 2);
    }

    @Test
    public void TwoWork() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        int prefetchCount = 1;
//        int prefetchCount = 3;//prefetchCount，这个值设置为3时，表示当前通道内，最多只有三条进来，再多就在外面排队
        // 不公平分发
        channel.basicQos(prefetchCount);
        logger.info(DateUtil.now() + "等待接收消息....");
        extracted(channel, 10);
    }

    private void extracted(Channel channel, int timeout) throws IOException, InterruptedException {
        //推送的消息如何进行消费的接口回调
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            logger.info("接收时间:" + DateUtil.now());
            //consumerTag 消费者标签，用来区分多个消费者
            logger.info("consumerTag:" + consumerTag);
            logger.info("properties:" + JSONUtil.toJsonStr(message.getProperties()));
            logger.info("envelope:" + JSONUtil.toJsonStr(message.getEnvelope()));
            logger.info("message:" + new String(message.getBody()));
            logger.info("");
            //true 代表批量应答 channel 上未应答的消息  false 单条应答
            try {
                TimeUnit.SECONDS.sleep(timeout);
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
            }
            boolean multiple = false;
            channel.basicAck(message.getEnvelope().getDeliveryTag(), multiple);
        };
        //取消消费的一个回调接口 如在消费的时候队列被删除掉了
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
        channel.basicConsume(TASK_QUEUE_NAME, false, deliverCallback, cancelCallback);
        TimeUnit.MINUTES.sleep(2);
    }

}
