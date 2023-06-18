package com.gold.tree;

import com.gold.dal.entity.UcUser;
import com.gold.service.UcUserService;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UcUserServiceTest {

    @Autowired
    private UcUserService ucUserService;

    @Test
    public void testInsert() {
        UcUser obj = new UcUser();
        obj.setEmail(String.join("", RandomStringUtils.randomAlphabetic(5), "@", String.valueOf(RandomUtils.nextLong()), ".com"));
        obj.setUserName(RandomStringUtils.randomAlphabetic(7));
        obj.setName(RandomStringUtils.randomAlphabetic(9));
        obj.setUserPwd(RandomStringUtils.randomAlphabetic(9));
        obj.setMobile(RandomStringUtils.randomNumeric(9));
        Integer aLong = ucUserService.saveAndUpdate(obj);
        System.out.println("版本号:" + aLong);
    }

    @Test
    public void testUpdateByIdSucc() {
        UcUser obj = new UcUser();
        obj.setEmail(String.join("", RandomStringUtils.randomAlphabetic(5), "@", String.valueOf(RandomUtils.nextLong()), ".com"));
        obj.setUserName(RandomStringUtils.randomAlphabetic(7));
        obj.setName(RandomStringUtils.randomAlphabetic(9));
        obj.setUserPwd(RandomStringUtils.randomAlphabetic(9));
        obj.setMobile(RandomStringUtils.randomNumeric(9));
        obj.setVersion(Integer.valueOf(67));
        obj.setId(Long.valueOf(7122682));
        Integer aLong = ucUserService.saveAndUpdate(obj);
        System.out.println("版本号:" + aLong);
    }


}
