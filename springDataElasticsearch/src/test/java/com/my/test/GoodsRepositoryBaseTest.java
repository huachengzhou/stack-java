package com.my.test;

import cn.hutool.core.bean.BeanUtil;
import com.my.ElasticsearchApplication;
import com.my.jpa.Goods;
import com.my.jpa.GoodsSQLServer;
import com.my.mapper.custom.GoodsMapper;
import com.my.repository.GoodsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * ElasticsearchTest测试
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ElasticsearchApplication.class})
public class GoodsRepositoryBaseTest {

    @Autowired
    private GoodsRepository goodsRepository;


    /**
     * from+size 浅分页
     */
    @Test
    public void testPageIndex()throws Exception{
        PageRequest pageRequest = PageRequest.of(1,100) ;
        Page<Goods> goodsList = goodsRepository.findAll(pageRequest);
        for (Goods goods:goodsList){
            System.out.println(goods);
        }
    }




}
