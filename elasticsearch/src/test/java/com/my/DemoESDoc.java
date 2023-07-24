package com.my;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.entity.JobEntity;
import com.my.entity.MovieEntity;
import com.my.study.JobEntityData;
import com.my.study.MovieData;
import lombok.Data;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.ShardSearchFailure;
import org.elasticsearch.client.*;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author : chengdu
 * @date :  2023/7/23-07
 **/
public class DemoESDoc {

    private static final int CONNECT_TIMEOUT = 700000;
    private static final int SOCKET_TIMEOUT = 600000;
    private static final int CONNECTION_REQUEST_TIMEOUT = 100000;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static final String LOCALHOST = "localhost";
    private static final int PORT = 9200;
    private static final String SCHEME = "http";

    private static final String INDEX_NAME = "study";

    private ThreadLocal<Boolean> IndexBoolean = new ThreadLocal<>();

    /**
     * 创建文档
     *
     * @throws Exception
     */
    @Test
    public void testCreateDoc() throws Exception {
        RestHighLevelClient client = getEsHighInit();
        UserEntity userEntity = new UserEntity();
        userEntity.setAddress("中国");
        userEntity.setAge(RandomUtil.randomInt(1, 100));
        userEntity.setId(RandomUtil.randomInt(1000000, 2000000));
        userEntity.setName(RandomUtil.randomString(5));
        userEntity.setUuid(UUID.fastUUID().toString());

        IndexRequest indexRequest = new IndexRequest();
        indexRequest.index(INDEX_NAME).id(userEntity.getUuid());

        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(userEntity);
        indexRequest.source(userJson, XContentType.JSON);

        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse.toString());


        System.out.println("DemoESDoc.testCreateDoc");
    }

    /**
     * 批量添加
     */
    @Test
    public void testCreateBatchDoc() throws Exception {
        RestHighLevelClient client = getEsHighInit();
        // 批量插入数据
        BulkRequest bulkRequest = new BulkRequest();
        int initialCapacity = 20;
        ObjectMapper mapper = new ObjectMapper();
        for (int i = 0; i < initialCapacity; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setAddress("中国");
            userEntity.setAge(RandomUtil.randomInt(1, 100));
            userEntity.setId(RandomUtil.randomInt(1000000, 2000000) + i);
            userEntity.setName(RandomUtil.randomString(5));
            userEntity.setUuid(UUID.fastUUID().toString());
            userEntity.setBirthday(new Date());
            bulkRequest.add(new IndexRequest().index(INDEX_NAME).id(userEntity.getId().toString()).source(mapper.writeValueAsString(userEntity), XContentType.JSON));
        }
        BulkResponse bulk = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulk.toString());
        System.out.println(bulk.getTook());
        System.out.println(bulk.getItems());

        client.close();
    }

    @Test
    public void testGetAllDoc() throws Exception {
        RestHighLevelClient client = getEsHighInit();
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);
        //可以指定type,也可以不指定，不指定查所有
//        searchRequest.types("my_type");
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = searchResponse.getHits();
        long totalHits = hits.getTotalHits().value;
        //匹配查询的结果集
        SearchHit[] searchHits = hits.getHits();
        for (SearchHit hit : searchHits) {
            String sourceAsString = hit.getSourceAsString();
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            System.out.println(sourceAsString);
        }
    }

    @Test
    public void testOne(){
        List<MovieEntity> movieEntityList = MovieData.getMovieEntityList();
        List<JobEntity> jobEntityList = JobEntityData.getJobEntityList();
    }

    /**
     * @param : client
     * @description : 查询文档————matchAll
     */
    public void searchDocumentByMatchAll(RestHighLevelClient client) throws Exception {
        //可以指定index,也可以不指定，不指定查所有
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);
        //可以指定type,也可以不指定，不指定查所有
//        searchRequest.types("my_type");

        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        //查询信息
        RestStatus status = searchResponse.status();
        TimeValue took = searchResponse.getTook();
        Boolean terminatedEarly = searchResponse.isTerminatedEarly();
        boolean timedOut = searchResponse.isTimedOut();

        int totalShards = searchResponse.getTotalShards();
        int successfulShards = searchResponse.getSuccessfulShards();
        int failedShards = searchResponse.getFailedShards();
        for (ShardSearchFailure failure : searchResponse.getShardFailures()) {
            // failures should be handled here
        }

        SearchHits hits = searchResponse.getHits();
        long totalHits = hits.getTotalHits().value;
        float maxScore = hits.getMaxScore();

        //匹配查询的结果集
        SearchHit[] searchHits = hits.getHits();
        for (SearchHit hit : searchHits) {
            // do something with the SearchHit
            String index = hit.getIndex();
            String type = hit.getType();
            String id = hit.getId();
            float score = hit.getScore();

            String sourceAsString = hit.getSourceAsString();
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
        }
    }


    /**
     * 检查文档情况
     */
    @After
    public void after() throws Exception {
        if (!IndexBoolean.get()) {
            System.out.println("创建索引" + INDEX_NAME);
        }
        System.out.println("DemoESDoc.after");
    }

    /**
     * 检查索引是否创建
     *
     * @throws Exception
     */
    @Before
    public void before() throws Exception {
        RestHighLevelClient client = getEsHighInit();
        IndicesClient indicesClient = client.indices();
        GetIndexRequest getIndexRequest = new GetIndexRequest(INDEX_NAME);
        boolean exists = indicesClient.exists(getIndexRequest, RequestOptions.DEFAULT);
        if (!exists) {
            CreateIndexRequest request = new CreateIndexRequest(INDEX_NAME);
            CreateIndexResponse createIndexResponse = indicesClient.create(request, RequestOptions.DEFAULT);
            System.out.println(createIndexResponse.index() + "......");
            if (!createIndexResponse.isAcknowledged()) {
                throw new Exception("索引创建异常");
            }
        }
        IndexBoolean.set(exists);
        System.out.println("DemoESDoc.before");
    }


    private RestHighLevelClient getEsHighInit() {
        RestClientBuilder http = RestClient.builder(new HttpHost(LOCALHOST, PORT, SCHEME))
                .setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
                    @Override
                    public RequestConfig.Builder customizeRequestConfig(RequestConfig.Builder requestConfigBuilder) {
                        requestConfigBuilder.setConnectTimeout(CONNECT_TIMEOUT);
                        requestConfigBuilder.setSocketTimeout(SOCKET_TIMEOUT);
                        requestConfigBuilder.setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT);
                        return requestConfigBuilder;
                    }
                });
        return new RestHighLevelClient(http);
    }

    @Data
    static class UserEntity {
        private String uuid;
        private Integer id;
        private String name;
        private Integer age;
        private Date birthday;
        private String address;
    }
}
