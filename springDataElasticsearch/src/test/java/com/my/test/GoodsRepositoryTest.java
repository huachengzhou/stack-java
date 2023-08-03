package com.my.test;

import cn.hutool.core.bean.BeanUtil;
import com.my.jpa.Goods;
import com.my.jpa.GoodsSQLServer;
import com.my.mapper.custom.GoodsMapper;
import com.my.repository.GoodsRepository;
import com.my.ElasticsearchApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

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
     * 导入测试数据,从sql中导入测试数据至es
     */
    @Test
    public void importAllData() {
        // 查询所有数据
        List<GoodsSQLServer> serverList = goodsMapper.findAll();
        List<Goods> goodsList = serverList.stream().map(obj -> {
            Goods goods = new Goods();
            BeanUtil.copyProperties(obj,goods,"createTime");
            goods.setCreateTime(obj.getCreateTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            return goods;
        }).collect(Collectors.toList());
        // 保存所有数据只ES中
        goodsRepository.saveAll(goodsList);
        System.out.println("ok");
    }

    /**
     * 添加文档
     */
    @Test
    public void save() {
        Goods goods = new Goods(1L, "Apple iPhone 13 ProMax 5G全网通手机", new BigDecimal(8999), 100, 1, "手机", "Apple", 0, LocalDate.now());
        goodsRepository.save(goods);
    }

    /**
     * 批量添加数据
     */
    @Test
    public void saveAll() {
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(new Goods(2L, "title2", new BigDecimal(12), 1, 1, "category2", "brandName2", 0, LocalDate.now()));
        goodsList.add(new Goods(3L, "title3", new BigDecimal(12), 1, 1, "category3", "brandName3", 0, LocalDate.now()));
        goodsList.add(new Goods(4L, "title4", new BigDecimal(12), 1, 1, "category4", "brandName4", 0, LocalDate.now()));
        goodsRepository.saveAll(goodsList);
    }

    /**
     * 根据编号查询
     */
    @Test
    public void findById() {
        Optional<Goods> optional = goodsRepository.findById(536563L);
        System.out.println(optional.orElse(null));
    }

    /**
     * 查询所有
     */
    @Test
    public void findAll() {
        Iterable<Goods> list = goodsRepository.findAll();
        for (Goods item : list) {
            System.out.println(item);
        }
    }

    /**
     * 分页查询
     */
    @Test
    public void findAllByPage() {
        // 数据太多了分页查询
        PageRequest pageRequest = PageRequest.of(0, 10);
        Iterable<Goods> list = goodsRepository.findAll(pageRequest);
        for (Goods item : list) {
            System.out.println(item);
        }
    }

    /**
     * 排序查询
     */
    @Test
    public void findAllBySort() {
        Iterable<Goods> list = goodsRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
        for (Goods item : list) {
            System.out.println(item);
        }
    }

    /**
     * 根据ID批量查询
     */
    @Test
    public void findAllById() {
        List<Long> asList = Arrays.asList(536563L, 562379L, 605616L, 635906L);
        Iterable<Goods> list = goodsRepository.findAllById(asList);
        for (Goods item : list) {
            System.out.println(item);
        }
    }

    /**
     * 统计数量
     */
    @Test
    public void count() {
        System.out.println(goodsRepository.count());
    }

    /**
     * 根据编号判断文档是否存在
     */
    @Test
    public void existsById() {
        System.out.println(goodsRepository.existsById(536563L));
    }

    /**
     * 删除文档
     */
    @Test
    public void delete() {
        goodsRepository.findById(1L).ifPresent(goods -> goodsRepository.delete(goods));
    }

    /**
     * 删除所有文档
     */
    @Test
    public void deleteAll() {
        goodsRepository.deleteAll();
    }

    /**
     * 根据编号批量删除文档
     */
    @Test
    public void deleteAllByIds() {
        goodsRepository.deleteAll(goodsRepository.findAllById(Arrays.asList(1L, 2L, 3L)));
    }

    /**
     * 根据编号删除文档
     */
    @Test
    public void deleteById() {
        goodsRepository.deleteById(4L);
    }

}
