package com.test.blue.bean;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blue.ShardingJdbcApplication;
import com.blue.entity.MsSchoolInfo;
import com.blue.service.IMsSchoolInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShardingJdbcApplication.class})
public class IMsSchoolInfoServiceTest {
    @Autowired
    private IMsSchoolInfoService iMsSchoolInfoService;

    @Test
    public void saveMsSchoolInfo() {
        int initialCapacity = 2000;
        List<MsSchoolInfo> msSchoolInfoList = new ArrayList<>(initialCapacity);
        for (int i = 0; i < initialCapacity; i++) {
            MsSchoolInfo msSchoolInfo = new MsSchoolInfo();
            msSchoolInfo.setTitle(UUID.fastUUID().toString());
            msSchoolInfo.setAddress(UUID.fastUUID().toString());
            msSchoolInfo.setName(UUID.fastUUID().toString());
            msSchoolInfo.setUuid(UUID.randomUUID().toString());
            msSchoolInfo.setCreator("zch");
            msSchoolInfo.setNumber(RandomUtil.randomInt());
            DateTime dateTime = RandomUtil.randomDate(new Date(), DateField.HOUR, 1, 22);
            msSchoolInfo.setBaseDate(dateTime.toJdkDate());
            msSchoolInfoList.add(msSchoolInfo);
        }
        iMsSchoolInfoService.saveBatch(msSchoolInfoList);
    }

    @Test
    public void testRemoveAll() {
        QueryWrapper<MsSchoolInfo> queryWrapper = new QueryWrapper<>();
        iMsSchoolInfoService.remove(queryWrapper);
    }

    @Test
    public void getList() {
        QueryWrapper<MsSchoolInfo> queryWrapper = new QueryWrapper<>();
        List<MsSchoolInfo> infoList = iMsSchoolInfoService.list(queryWrapper);
        for (MsSchoolInfo msSchoolInfo : infoList) {
            System.out.println(JSONUtil.toJsonStr(msSchoolInfo));
        }
    }

}
