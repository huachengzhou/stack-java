package com.ng.my.ask;

import com.my.common.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ConsumerAskOne {


    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static final String ACK_QUEUE_NAME = "ack_queue";

    @Test
    public void executeAsk() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();

        logger.info("C1 等待接收消息处理时间较短");

        extracted(channel, 1);

        TimeUnit.MINUTES.sleep(3);
        logger.info("end");
    }

    @Test
    public void executeTwoAsk() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();

        logger.info("C2 等待接收消息处理时间较短");

        extracted(channel, 30);

        TimeUnit.MINUTES.sleep(3);
        logger.info("end");
    }

    private void extracted(Channel channel, long timeout) throws IOException {
        //消息消费的时候如何处理消息
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody());
            try {
                TimeUnit.SECONDS.sleep(timeout);
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
            }
            System.out.println("接收到消息:" + message);
            /**
             * 1.消息标记 tag
             * 2.是否批量应答未应答消息
             */
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        };
        //采用手动应答
        boolean autoAck = false;
        channel.basicConsume(ACK_QUEUE_NAME, autoAck, deliverCallback, (consumerTag) -> {
            System.out.println(consumerTag + "消费者取消消费接口回调逻辑");
        });
    }

}
