package com.my.test;

import cn.hutool.json.JSONUtil;
import com.my.mapper.custom.GoodsMapper;
import com.my.ElasticsearchApplication;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.GetAliasesResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.Set;

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
        searchRequest.indices("goods");
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


}
