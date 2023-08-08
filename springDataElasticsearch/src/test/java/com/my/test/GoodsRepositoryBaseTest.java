package com.my.test;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.my.ElasticsearchApplication;
import com.my.jpa.Goods;
import com.my.jpa.GoodsSQLServer;
import com.my.mapper.custom.GoodsMapper;
import com.my.repository.GoodsRepository;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
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
import java.util.*;
import java.util.stream.Collectors;

/**
 * ElasticsearchTest测试
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ElasticsearchApplication.class})
public class GoodsRepositoryBaseTest {

    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * from+size 浅分页
     * 注意：es是基于分片的，假设有3个分片，from=100，size=10。则会根据排序规则从3个分片中各取回100条数据数据，然后汇总成300条数据后选择最前边的10条数据
     */
    @Test
    public void testPageIndex() throws Exception {
        PageRequest pageRequest = PageRequest.of(1, 100);
        Page<Goods> goodsList = goodsRepository.findAll(pageRequest);
        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
    }

    /**
     * 添加单个文档
     */
    @Test
    public void saveOne() {
        Goods goods = new Goods();
        goods.setId(29811L);
//        goods.setId(19999L + RandomUtil.randomLong(1000, 10000));
        goods.setTitle("苹果iPhone 14 Pro Max");
        goods.setCategoryName("apple");
        goods.setPrice(new BigDecimal("8999"));
        goods.setStock(100);
        goods.setStatus(0);
        goods.setCreateTime(LocalDate.now());
        Goods save = goodsRepository.save(goods);
        System.out.println(JSONUtil.toJsonStr(save));
    }

    /**
     * 获取文档
     */
    @Test
    public void getOne() {
        Optional<Goods> goods = goodsRepository.findById(29811L);
        System.out.println(JSONUtil.toJsonStr(goods.get()));
    }

    /**
     * 查找所有 并且分页
     */
    @Test
    public void findAll() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Iterable<Goods> iterable = goodsRepository.findAll(pageRequest);
        Iterator<Goods> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Goods next = iterator.next();
            System.out.println(JSONUtil.toJsonStr(next));
        }
    }


    /**
     * 查找所有 排序
     */
    @Test
    public void findAllBySort() {
        Iterable<Goods> iterable = goodsRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
        Iterator<Goods> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Goods next = iterator.next();
            System.out.println(JSONUtil.toJsonStr(next));
        }
    }


    /**
     * 根据id批量查找
     */
    @Test
    public void findAllById() {
        List<Long> asList = Arrays.asList(536563L, 562379L, 605616L, 635906L);
        Iterable<Goods> iterable = goodsRepository.findAllById(asList);
        Iterator<Goods> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Goods next = iterator.next();
            System.out.println(JSONUtil.toJsonStr(next));
        }
    }


    /**
     * 统计数量
     */
    @Test
    public void count() {
        long count = goodsRepository.count();
        System.out.println("数量:" + count);
    }

    /**
     * 根据编号判断文档是否存在
     */
    @Test
    public void existsById() {
        boolean exists = goodsRepository.existsById(29811L);
        System.out.println("是否存在:" + exists);
    }


    /**
     * 删除文档
     */
    @Test
    public void deleteById() {
        long id = 29811L;
        if (goodsRepository.existsById(id)) {
            goodsRepository.deleteById(id);
        }

        goodsRepository.deleteById(id);
    }

    /**
     * 删除所有文档
     */
    @Test
    public void deleteAll() {
        goodsRepository.deleteAll();
    }

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
     * 添加所有
     */
    @Test
    public void saveAll() {
        String[] phoneTypes = new String[]{"OPPOOPPO",
                "Apple（苹果）苹果",
                "Samsung（三星）三星",
                "荣耀荣耀",
                "OnePlus（一加）一加",
                "MEIZU（魅族）魅族",
                "努比亚努比亚",
                "索尼移动索尼",
                "ZTE（中兴）中兴",
                "Hisense（海信）海信",
                "金立金立",
                "LGLG",
                "Philips（飞利浦）飞利浦",
                "TCLTCL",
                "Sharp（夏普）夏普",
                "ASUS（华硕）华硕",
                "Microsoft（微软）微软",
                "GOME（国美手机）国美手机",
                "SUGARSUGAR",
                "天语天语",
                "Newsmy（纽曼）纽曼",
                "Konka（康佳）康佳",
                "Razer（雷蛇）雷蛇",
                "Haier（海尔）海尔",
                "SOYES（索野）索野",
                "21克21克",
                "GreenOrange（青橙）青橙",
                "koobee（酷比）酷比",
                "angelcare（守护宝）守护宝",
                "neken（尼凯恩）尼凯恩",
                "乐目乐目",
                "BOWAY（邦华）邦华",
                "vivo",
                "华为",
                "OPPO",
                "三星",
                "苹果",
                "荣耀",
                "小米",
                "一加",
                "红米",
                "魅族",
                "realme",
                "联想",
                "努比亚",
                "Moto",
                "锤子科技",
                "诺基亚",
                "索尼移动",
                "中兴",
                "ROG",
                "海信",
                "黑鲨",
                "金立",
                "谷歌",
                "360",
                "酷派",
                "LG",
                "黑莓",
                "飞利浦",
                "HTC",
                "美图",
                "VERTU",
                "TCL",
                "夏普",
                "小辣椒",
                "8848",
                "中国移动",
                "华硕",
                "AGM",
                "微软",
                "长虹",
                "朵唯",
                "国美手机",
                "SUGAR",
                "天语",
                "纽曼",
                "詹姆士",
                "康佳",
                "遨游",
                "欧奇",
                "雷蛇"};
        List<Goods> goodsList = new ArrayList<>(phoneTypes.length);
        Long id = 3000000L;
        for (String type : phoneTypes) {
            Goods goods = new Goods();
            goods.setPrice(RandomUtil.randomBigDecimal(new BigDecimal(5000), new BigDecimal(20000)));
            goods.setId(++id);
            goods.setCategoryName(type);
            goods.setBrandName(type);
            goods.setTitle(type + RandomUtil.randomInt(1, 10));
            goods.setSaleNum(RandomUtil.randomInt(1, 10));
            goods.setCreateTime(LocalDate.now());
            goods.setStatus(1);
            goods.setStock(1);
            goodsList.add(goods);
        }
        if (CollUtil.isNotEmpty(goodsList)) {
            goodsRepository.saveAll(goodsList);
        }
    }

    /**
     * 匹配所有  分页查询
     */
    @Test
    public void searchSimple() {
        PageRequest pageRequest = PageRequest.of(1, 10);
        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        Page<Goods> goodsPage = goodsRepository.search(queryBuilder, pageRequest);
        System.out.println(goodsPage.getTotalElements());
        System.out.println(goodsPage.getTotalPages());
        System.out.println(goodsPage.getSize());
        List<Goods> goodsList = goodsPage.getContent();
        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
    }

    /**
     * matchQuery 匹配查询：matchQuery可以简单理解为mysql中的like，因为在elasticsearch中使用matchQuery查询时，
     * 他会对查询的field进行分词。当然我们进行查询的这个field的mapping必须是text类型
     */
    @Test
    public void matchQuery() {
        //必须把 type = FieldType.Text 表示分词模式
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("brandName","苹");
        Iterable<Goods> goodsIterable = goodsRepository.search(queryBuilder);
        for (Goods goods : goodsIterable) {
            System.out.println(goods);
        }
    }


    /**
     * matchPhraseQuery短语搜索：相当于sql的=查询，与matchQuery的区别在于，matchPhraseQuery查询不会被分词，
     * 而是直接以一个短语的形式查询，而如果你在创建索引所使用的field的value中没有这么一个短语（顺序无差，且连接在一起），那么将查询不出任何结果。
     */
    @Test
    public void matchPhraseQuery(){
        QueryBuilder queryBuilder = QueryBuilders.matchPhraseQuery("categoryName","魅族");
        Iterable<Goods> goodsIterable = goodsRepository.search(queryBuilder);
        for (Goods goods : goodsIterable) {
            System.out.println(goods);
        }
    }

    /**
     * termQuery等值搜索：相当于sql语句中的“=”，
     * 使用这个搜索一般是对索引中keyword的mapping进行等值搜索。
     * term query 属于过滤器查询，可以处理数字（numbers）、布尔值（Booleans）、日期（dates）以及文本（text）
     */
    @Test
    public void termQuery(){
//        QueryBuilder queryBuilder = QueryBuilders.termQuery("saleNum","2");
        QueryBuilder queryBuilder = QueryBuilders.termsQuery("saleNum","2","8");
        Iterable<Goods> goodsIterable = goodsRepository.search(queryBuilder);
        for (Goods goods : goodsIterable) {
            System.out.println(goods);
        }
    }

    /**
     * 组合（多条件）查询：boolQuery 组合查询条件：
     * boolQuery用来将搜索的条件进行组合，即将多个组合条件组合在一起，
     * 常用的几种组合方式有
     * must（and，必须匹配）、should(or，或者)、mustNot(!=，必须不匹配)
     */
    @Test
    public void boolQuery(){
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        queryBuilder.must(QueryBuilders.matchQuery("title","苹果"));
        queryBuilder.must(QueryBuilders.termsQuery("saleNum","2","8"));
        System.out.println(queryBuilder.toString());
        Iterable<Goods> goodsIterable = goodsRepository.search(queryBuilder);
        for (Goods goods : goodsIterable) {
            System.out.println(goods);
        }
    }


    @Test
    public void boolShouldQuery(){
        //唯一不同的是es不是like  title 字段是分词的  比like范围更广
        //select * from goods where 1=1 and saleNum in (2,8) and (title like '%苹果%' or title like '%三星%')
        BoolQueryBuilder orBuild = QueryBuilders.boolQuery();
        orBuild.should(QueryBuilders.matchQuery("title","苹果"));
        orBuild.should(QueryBuilders.matchQuery("title","三星"));

        BoolQueryBuilder andBuild = QueryBuilders.boolQuery();
        andBuild.must(QueryBuilders.termsQuery("saleNum","2","8"));

        andBuild.must(orBuild) ;
        System.out.println(andBuild.toString());
        Iterable<Goods> goodsIterable = goodsRepository.search(andBuild);
        for (Goods goods : goodsIterable) {
            System.out.println(goods);
        }
    }

    /**
     * rangeQuery，range query可以处理数字（numbers）、日期（dates）以及字符串，不过字符串还是不要用范围查询的好，效率会很低
     */
    @Test
    public void rangeQuery(){
        //select * from goods where 1=1 and saleNum >= 2 and saleNum <= 3
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        queryBuilder.must(QueryBuilders.rangeQuery("saleNum").from("2").to("3"));
        System.out.println(queryBuilder.toString());
        Iterable<Goods> goodsIterable = goodsRepository.search(queryBuilder);
        for (Goods goods : goodsIterable) {
            System.out.println(goods);
        }
    }

    /**
     * 大于
     */
    @Test
    public void test_gt(){
        //select * from goods where 1=1 and saleNum > 7
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        queryBuilder.must(QueryBuilders.rangeQuery("saleNum").gt("7"));
        System.out.println(queryBuilder.toString());
        Iterable<Goods> goodsIterable = goodsRepository.search(queryBuilder);
        for (Goods goods : goodsIterable) {
            System.out.println(goods);
        }
    }


    /**
     * 大于等于
     */
    @Test
    public void test_gte(){
        //select * from goods where 1=1 and saleNum >= 7
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        queryBuilder.must(QueryBuilders.rangeQuery("saleNum").gte("7"));
        System.out.println(queryBuilder.toString());
        Iterable<Goods> goodsIterable = goodsRepository.search(queryBuilder);
        for (Goods goods : goodsIterable) {
            System.out.println(goods);
        }
    }

    /**
     * 小于
     */
    @Test
    public void test_lt(){
        //select * from goods where 1=1 and saleNum < 6
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        queryBuilder.must(QueryBuilders.rangeQuery("saleNum").lt("6"));
        System.out.println(queryBuilder.toString());
        Iterable<Goods> goodsIterable = goodsRepository.search(queryBuilder);
        for (Goods goods : goodsIterable) {
            System.out.println(goods);
        }
    }

    /**
     * 小于等于
     */
    @Test
    public void test_lte(){
        //select * from goods where 1=1 and saleNum <= 6
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        queryBuilder.must(QueryBuilders.rangeQuery("saleNum").lte("6"));
        System.out.println(queryBuilder.toString());
        Iterable<Goods> goodsIterable = goodsRepository.search(queryBuilder);
        for (Goods goods : goodsIterable) {
            System.out.println(goods);
        }
    }

    @Test
    public void moreMust(){
        BoolQueryBuilder and1 = QueryBuilders.boolQuery();
        and1.must(QueryBuilders.rangeQuery("saleNum").lte("6"));

        BoolQueryBuilder and2 = QueryBuilders.boolQuery();
        and2.should(QueryBuilders.matchQuery("title","苹果"));

        QueryBuilder qb = QueryBuilders.boolQuery().must(and1).must(and2);
        System.out.println(qb.toString());
        Iterable<Goods> goodsIterable = goodsRepository.search(qb);
        for (Goods goods : goodsIterable) {
            System.out.println(goods);
        }
    }


    //https://blog.csdn.net/yuhui123999/article/details/105202140/

}
