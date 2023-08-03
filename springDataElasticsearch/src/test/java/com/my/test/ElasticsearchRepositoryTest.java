package com.my.test;

import com.my.mapper.custom.GoodsMapper;
import com.my.ElasticsearchApplication;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest;
import org.elasticsearch.client.GetAliasesResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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


}
