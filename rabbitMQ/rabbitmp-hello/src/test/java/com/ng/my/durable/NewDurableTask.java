package com.ng.my.durable;

import com.my.common.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class NewDurableTask {
    private static final String TASK_QUEUE_NAME = "task_durable_queue";
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void acceptProducer() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        //让消息持久化
        boolean durable = true;
        channel.queueDeclare(TASK_QUEUE_NAME, durable, false, false, null);

        //从控制台当中接受信息
        logger.info("start");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String message = scanner.next();

            channel.basicPublish("", TASK_QUEUE_NAME,
                    MessageProperties.PERSISTENT_TEXT_PLAIN,
                    message.getBytes("UTF-8"));
            logger.info(" [x] Sent '" + message + "'");
        }

        TimeUnit.MINUTES.sleep(2);
        logger.info("end");
    }

}
