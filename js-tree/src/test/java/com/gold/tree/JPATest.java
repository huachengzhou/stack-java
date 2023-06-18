package com.gold.tree;

import com.jpa.entity.JobJPA;
import com.jpa.service.JobJPAService;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by Lenovo on 2020/8/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JPATest {

    @Autowired
   private JobJPAService jobJPAService;


    @Test
    public void run2() {
        JobJPA jobJPA = new JobJPA();
        jobJPA.setName(RandomStringUtils.random(5));
        jobJPA.setUrl(RandomStringUtils.random(5));
        jobJPA.setCreateDate(new Date());
        jobJPAService.saveData(jobJPA);
        System.out.println(jobJPA);
        int a = 0;
        Integer a1 = 0;
//        synchronized (a);
        synchronized (a1){

        }
    }
}
