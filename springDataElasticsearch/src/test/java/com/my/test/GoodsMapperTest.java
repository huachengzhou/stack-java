package com.my.test;


import cn.hutool.core.collection.CollUtil;
import com.my.jpa.Goods;
import com.my.jpa.GoodsSQLServer;
import com.my.mapper.custom.GoodsMapper;
import com.my.ElasticsearchApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ElasticsearchApplication.class})
public class GoodsMapperTest {

    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    public void testFindAll(){
        List<GoodsSQLServer> goodsList = goodsMapper.findAll();
        if (CollUtil.isNotEmpty(goodsList)){

        }
    }

}
