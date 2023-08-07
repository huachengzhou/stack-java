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
     * 注意：es是基于分片的，假设有3个分片，from=100，size=10。则会根据排序规则从3个分片中各取回100条数据数据，然后汇总成300条数据后选择最前边的10条数据
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
