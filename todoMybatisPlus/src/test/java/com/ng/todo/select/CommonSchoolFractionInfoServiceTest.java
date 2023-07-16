package com.ng.todo.select;


import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ng.todo.common.utils.MyBatisPlusUtils;
import com.ng.todo.entity.CommonSchoolFractionInfo;
import com.ng.todo.mapper.CommonSchoolFractionInfoMapper;
import com.ng.todo.service.CommonSchoolFractionInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonSchoolFractionInfoServiceTest {
    private final Logger logger = LoggerFactory.getLogger(getClass()) ;
    @Autowired
    private CommonSchoolFractionInfoService commonSchoolFractionInfoService;
    @Autowired
    private CommonSchoolFractionInfoMapper mapper;

    @Test
    public void test_findDataUuidList(){
        int year = 2013;
        List<String> dataUuidList = commonSchoolFractionInfoService.findDataUuidList(year);
        logger.info(StrUtil.join(",",dataUuidList));


    }

    @Test
    public void testOther(){
        int year = 2013;
        QueryWrapper<CommonSchoolFractionInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(CommonSchoolFractionInfo.YEAR,year);

        List<String> uuidList = MyBatisPlusUtils.findUuidList(mapper, queryWrapper);
        logger.info(StrUtil.join(",",uuidList));

    }


    @Test
    public void testOther1()throws Exception{
        String uuid = "siH4szuh";
        commonSchoolFractionInfoService.removeEntity(CommonSchoolFractionInfo.class,(entity -> entity.setSourceText(UUID.fastUUID().toString())),new QueryWrapper<>().eq(CommonSchoolFractionInfo.UUID, uuid));
    }
}
