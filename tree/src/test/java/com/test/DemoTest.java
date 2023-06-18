package com.test;

import com.blue.dal.dto.UserDto;
import com.blue.dal.entity.UserBoot;
import com.blue.service.UserBootService;
import com.blue.spring.SpringBootDemoApplication;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.*;

/**
 * @Author zch
 * @Description
 * @createDate 2018/11/18
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootDemoApplication.class})
public class DemoTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserBootService userBootService;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDto userDto;

    @Test
    public void testA(){
        List<UserBoot> userBootList = new ArrayList<>(5) ;

        for (int i = 0; i < 5; i++) {
            Random random = new Random(System.currentTimeMillis());
            UserBoot userBoot = new UserBoot();
            userBoot.setPid(0);
            userBoot.setUserName(RandomStringUtils.randomPrint(6));
            userBoot.setCreateDate(new Date());
            userBoot.setAge(random.nextInt(100));
            userBootService.saveUserBoot(userBoot);
            userBootList.add(userBoot) ;
        }
        if (CollectionUtils.isEmpty(userBootList)){
            return;
        }
        Iterator<UserBoot> iterator = userBootList.iterator();
        while (iterator.hasNext()){
            UserBoot parent = iterator.next();
            List<UserBoot> bootList = new ArrayList<>(5) ;
            for (int i = 0; i < 5; i++) {
                Random random = new Random(System.currentTimeMillis());
                UserBoot userBoot = new UserBoot();
                userBoot.setPid(parent.getId());
                userBoot.setUserName(RandomStringUtils.randomPrint(6));
                userBoot.setCreateDate(new Date());
                userBoot.setAge(random.nextInt(100));
                userBootService.saveUserBoot(userBoot);
                bootList.add(userBoot) ;
            }
            if (CollectionUtils.isEmpty(bootList)){
                continue;
            }
            Iterator<UserBoot> userBootIterator = bootList.iterator();
            while (userBootIterator.hasNext()){
                UserBoot child = userBootIterator.next();
                for (int i = 0; i < 5; i++) {
                    Random random = new Random(System.currentTimeMillis());
                    UserBoot userBoot = new UserBoot();
                    userBoot.setPid(child.getId());
                    userBoot.setUserName(RandomStringUtils.randomPrint(6));
                    userBoot.setCreateDate(new Date());
                    userBoot.setAge(random.nextInt(100));
                    userBootService.saveUserBoot(userBoot);
                }
            }
        }

    }

    @Test
    public void testB(){
        if (dataSource != null){
            System.out.println(dataSource);
        }
    }

    @Test
    public void testC(){
        System.out.println(userDto);
        logger.info("testC");
        logger.debug("testC");
        logger.error("testC");
        logger.warn("testC");
    }

    @After
    public void after(){
        List<UserBoot> userBootList = userBootService.findListUserBoot();
        if (CollectionUtils.isEmpty(userBootList)){
            return;
        }
        userBootList.forEach(userBoot -> {
            logger.info(userBoot.toString());
        });
    }
}
