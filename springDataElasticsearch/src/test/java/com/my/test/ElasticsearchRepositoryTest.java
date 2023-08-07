package com.my.test;

import cn.hutool.json.JSONUtil;
import com.my.jpa.Goods;
import com.my.mapper.custom.GoodsMapper;
import com.my.ElasticsearchApplication;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.client.GetAliasesResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * ElasticsearchTest测试
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ElasticsearchApplication.class})
public class ElasticsearchRepositoryTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    public static String INDEX_NAME = "" ;

    @Before
    public void before(){
        Class<Goods> goodsClass = Goods.class;
        Document annotation = goodsClass.getAnnotation(Document.class);
        INDEX_NAME = annotation.indexName();
    }


    @Test
    public void test1(){
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
     * from+size 浅分页
     */
    @Test
    public void testPageIndex()throws Exception{
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder() ;
        BoolQueryBuilder queryBuilder = new BoolQueryBuilder();
        searchSourceBuilder.query(queryBuilder).from(1).size(100);
        SearchRequest searchRequest = new SearchRequest() ;
        searchRequest.indices(INDEX_NAME);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = searchResponse.getInternalResponse().hits();
        SearchHit[] searchHits = hits.getHits();
        for (SearchHit hit : searchHits) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            System.out.println(JSONUtil.toJsonStr(sourceAsMap));
        }
        restHighLevelClient.close();
    }

    /**
     * 深度分页
     * @throws Exception
     */
    @Test
    public void testScrollIndex()throws Exception{
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder() ;
        BoolQueryBuilder queryBuilder = new BoolQueryBuilder();
        searchSourceBuilder.query(queryBuilder).from(0).size(100);
        SearchRequest searchRequest = new SearchRequest() ;
        searchRequest.indices(INDEX_NAME);
        searchRequest.source(searchSourceBuilder);
        //失效时间为3min
        Scroll scroll = new Scroll(TimeValue.timeValueMinutes(3));
        //封存快照
        searchRequest.scroll(scroll);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        //计算总页数
        long totalCount = searchResponse.getHits().getTotalHits().value;
        int pageSize = (int) Math.ceil((float) totalCount / 2);
        //多次遍历分页，获取结果
        String scrollId = searchResponse.getScrollId();

        List<SearchHit> searchHits = new ArrayList<>() ;
        searchHits.addAll(Arrays.asList(searchResponse.getHits().getHits())) ;
        for (int i = 1; i <= pageSize; i++) {
            //获取scrollId
            SearchScrollRequest searchScrollRequest = new SearchScrollRequest(scrollId);
            searchScrollRequest.scroll(scroll);
            //这里每次调用一次就会获取下一页的数据  但是不能跳页
            SearchResponse response = restHighLevelClient.scroll(searchScrollRequest, RequestOptions.DEFAULT);
            SearchHits hits = response.getHits();
            scrollId = response.getScrollId();
            Iterator<SearchHit> iterator = hits.iterator();
            while (iterator.hasNext()) {
                SearchHit next = iterator.next();
                searchHits.add(next);
            }
        }


        for (SearchHit hit : searchHits) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            System.out.println(JSONUtil.toJsonStr(sourceAsMap));
        }
        restHighLevelClient.close();
    }


}
