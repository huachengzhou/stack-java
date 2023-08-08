package com.my.test;

import cn.hutool.json.JSONUtil;
import com.my.ElasticsearchApplication;
import com.my.jpa.Goods;
import com.my.mapper.custom.GoodsMapper;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest;
import org.elasticsearch.client.GetAliasesResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * ElasticsearchSpringDataTest 测试
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ElasticsearchApplication.class})
public class ElasticsearchSpringDataTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private RestHighLevelClient restHighLevelClient;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    public static String INDEX_NAME = "";

    @Before
    public void before() {
        Class<Goods> goodsClass = Goods.class;
        Document annotation = goodsClass.getAnnotation(Document.class);
        INDEX_NAME = annotation.indexName();
    }


    @Test
    public void test1() {
        System.out.println(restHighLevelClient);
    }

    /**
     * 获取所有索引
     *
     * @throws Exception
     */
    @Test
    public void testGetAllIndex() throws Exception {
        GetAliasesRequest aliasesRequest = new GetAliasesRequest();
        GetAliasesResponse aliasesResponse = restHighLevelClient.indices().getAlias(aliasesRequest, RequestOptions.DEFAULT);
        Set<String> indexSet = aliasesResponse.getAliases().keySet();

        logger.info("获取所有索引");
        indexSet.forEach(s -> logger.info(s));
    }


    /**
     * 精确查询（termQuery）
     */
    @Test
    public void termQuery() {
        //查询条件(词条查询：对应ES query里的term)
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("categoryName", "手机");
        //创建查询条件构建器SearchSourceBuilder(对应ES外面的大括号)
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(termQueryBuilder).build();
        org.springframework.data.elasticsearch.core.SearchHits<Goods> searchHits = elasticsearchRestTemplate.search(nativeSearchQuery, Goods.class);
        Iterator<org.springframework.data.elasticsearch.core.SearchHit<Goods>> iterator = searchHits.iterator();
        while (iterator.hasNext()) {
            org.springframework.data.elasticsearch.core.SearchHit<Goods> searchHit = iterator.next();
            System.out.println(searchHit.getContent());
        }
    }

    /**
     * terms:多个查询内容在一个字段中进行查询
     */
    @Test
    public void termsQuery() {
        //查询条件(词条查询：对应ES query里的term)
        TermsQueryBuilder termsQueryBuilder = QueryBuilders.termsQuery("categoryName", "手机", "平板电视");
        //创建查询条件构建器SearchSourceBuilder(对应ES外面的大括号)
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(termsQueryBuilder).build();
        org.springframework.data.elasticsearch.core.SearchHits<Goods> searchHits = elasticsearchRestTemplate.search(nativeSearchQuery, Goods.class);
        Iterator<org.springframework.data.elasticsearch.core.SearchHit<Goods>> iterator = searchHits.iterator();
        while (iterator.hasNext()) {
            org.springframework.data.elasticsearch.core.SearchHit<Goods> searchHit = iterator.next();
            System.out.println(searchHit.getContent());
        }
    }


    @Test
    public void matchQuery() {
        //查询条件(词条查询：对应ES query里的match)
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("title", "Apple IPhone 白色").analyzer("ik_smart").operator(Operator.AND);
        //创建查询条件构建器SearchSourceBuilder(对应ES外面的大括号)
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(matchQueryBuilder).build();
        //查询,获取查询结果
        org.springframework.data.elasticsearch.core.SearchHits<Goods> searchHits = elasticsearchRestTemplate.search(nativeSearchQuery, Goods.class);
        //获取总记录数
        long totalHits = searchHits.getTotalHits();
        System.out.println("totalHits = " + totalHits);
        Iterator<org.springframework.data.elasticsearch.core.SearchHit<Goods>> iterator = searchHits.iterator();
        while (iterator.hasNext()) {
            org.springframework.data.elasticsearch.core.SearchHit<Goods> searchHit = iterator.next();
            System.out.println(searchHit.getContent());
        }
    }

    /**
     * match_all：查询全部。
     */
    @Test
    public void matchAllQuery(){
        //查询条件(词条查询：对应ES query里的match)
        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        //创建查询条件构建器SearchSourceBuilder(对应ES外面的大括号)
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(matchAllQueryBuilder).build();
        //查询,获取查询结果
        org.springframework.data.elasticsearch.core.SearchHits<Goods> searchHits = elasticsearchRestTemplate.search(nativeSearchQuery, Goods.class);
        //获取总记录数
        long totalHits = searchHits.getTotalHits();
        System.out.println("totalHits = " + totalHits);
        Iterator<org.springframework.data.elasticsearch.core.SearchHit<Goods>> iterator = searchHits.iterator();
        while (iterator.hasNext()) {
            org.springframework.data.elasticsearch.core.SearchHit<Goods> searchHit = iterator.next();
            System.out.println(searchHit.getContent());
        }
    }

    /**
     * match_phrase：短语查询，在match的基础上进一步查询词组，可以指定slop分词间隔。
     */
    @Test
    public void matchPhraseQuery(){
        //查询条件(词条查询：对应ES query里的match_all)
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = QueryBuilders.matchPhraseQuery("title","华为") ;
        //创建查询条件构建器SearchSourceBuilder(对应ES外面的大括号)
        NativeSearchQuery  nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(matchPhraseQueryBuilder).build();
        //查询,获取查询结果
        org.springframework.data.elasticsearch.core.SearchHits<Goods> searchHits = elasticsearchRestTemplate.search(nativeSearchQuery, Goods.class);
        //获取总记录数
        long totalHits = searchHits.getTotalHits();
        System.out.println("totalHits = " + totalHits);
        Iterator<org.springframework.data.elasticsearch.core.SearchHit<Goods>> iterator = searchHits.iterator();
        while (iterator.hasNext()) {
            org.springframework.data.elasticsearch.core.SearchHit<Goods> searchHit = iterator.next();
            System.out.println(searchHit.getContent());
        }
    }

    /**
     * multi_match：多字段查询，使用相当的灵活，可以完成match_phrase和match_phrase_prefix的工作。
     */
    @Test
    public void multiMatchQuery(){
        //查询条件(词条查询：对应ES query里的multi_match)
        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery("华为","title","categoryName").analyzer("ik_smart") ;
//        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery("华为和Apple","title","categoryName").analyzer("ik_smart") ;
        //创建查询条件构建器SearchSourceBuilder(对应ES外面的大括号)
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(multiMatchQueryBuilder).build();
        //查询,获取查询结果
        org.springframework.data.elasticsearch.core.SearchHits<Goods> searchHits = elasticsearchRestTemplate.search(nativeSearchQuery, Goods.class);
        //获取总记录数
        long totalHits = searchHits.getTotalHits();
        System.out.println("totalHits = " + totalHits);
        Iterator<org.springframework.data.elasticsearch.core.SearchHit<Goods>> iterator = searchHits.iterator();
        while (iterator.hasNext()) {
            org.springframework.data.elasticsearch.core.SearchHit<Goods> searchHit = iterator.next();
            System.out.println(searchHit.getContent());
        }
    }


}
