package com.my.test;

import com.my.jpa.Goods;
import com.my.mapper.custom.GoodsMapper;
import com.my.repository.GoodsRepository;
import com.my.ElasticsearchApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * ElasticsearchTest测试
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ElasticsearchApplication.class})
public class GoodsRepositoryTest {

    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private GoodsMapper goodsMapper;




    /**
     * 导入测试数据,从mysql中导入测试数据至es
     */
    @Test
    public void importAllData() {
        // 查询所有数据
        List<Goods> lists = goodsMapper.findAll();
        // 保存所有数据只ES中
        goodsRepository.saveAll(lists);
        System.out.println("ok");
    }

}
