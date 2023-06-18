package com.test;

import com.blue.common.CommonUtils;
import com.blue.dal.entity.UserBoot;
import com.blue.spring.SpringBootDemoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import tool.utils.FormatUtils;

/**
 * Created by zch on 2019-12-6.
 */

@SpringBootTest(classes = {SpringBootDemoApplication.class})
public class LoggerTest extends AbstractTestNGSpringContextTests {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Test
    public void testAll(){
        System.out.println(Integer.parseInt("44.3636"));
        logger.info("info");
        logger.debug("debug");
        logger.error("error");
        logger.warn("warn");
        System.out.println(FormatUtils.entityNameConvertToTableName(UserBoot.class));
    }

}
