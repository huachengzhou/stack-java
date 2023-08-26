package com.ng.my.ask;

import com.my.common.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ProducerAskOne {


    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static final String TASK_QUEUE_NAME = "ack_queue";

    @Test
    public void acceptProducer() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();

        //创建一个队列
        channel.queueDeclare(TASK_QUEUE_NAME, false, false, false, null);


        //从控制台当中接受信息
        logger.info("start");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String message = scanner.next();
            logger.info(" [x] Sent '" + message + "'");
            channel.basicPublish("", TASK_QUEUE_NAME, null, message.getBytes("UTF-8"));

            System.out.println(" [x] Sent '" + message + "'");
        }

        TimeUnit.MINUTES.sleep(2);
        logger.info("end");
    }


}
