package com.blue.service;

import com.blue.common.BootstrapTableVo;
import com.blue.entity.SimpleBean;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: zch
 * @Date: 2018/9/5 22:19
 * @Description:
 */
@Service
public class BiologyBeanService {

    public BootstrapTableVo getBootstrapTableVo(){
        BootstrapTableVo vo = new BootstrapTableVo();
        SimpleBean simpleBean = null;
        List<SimpleBean> simpleBeanList = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            simpleBean = new SimpleBean();
            simpleBean.setId(RandomUtils.nextInt(10,10000)).setName(RandomStringUtils.random(5)).setTitle(RandomStringUtils.random(5));
            simpleBeanList.add(simpleBean);
        }
        vo.setRows(simpleBeanList);
        vo.setTotal(Integer.toUnsignedLong(simpleBeanList.size()));
        return vo;
    }

    public List<SimpleBean> simpleBeanList(){
        return BiologyBeanPoUtils.getBiologyBeanPoUtils().simpleBeanList();
    }

    public Object biologyBeanPoList(){
        return BiologyBeanPoUtils.getBiologyBeanPoUtils().nodeExampleList();
    }
}
