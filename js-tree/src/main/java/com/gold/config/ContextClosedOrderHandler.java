package com.gold.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Lenovo on 2020/8/15.
 */
@Component
public class ContextClosedOrderHandler implements ApplicationListener, ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(ContextClosedOrderHandler.class);

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextClosedEvent) {
            logger.info("开始关闭spring容器");
            try {
//                ProtocolConfig.destroyAll();
                logger.info("spring关闭事件,开始销毁bean");
                //如果应用里面还有其它的自定义的线程池等，也可以在这里关闭
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}