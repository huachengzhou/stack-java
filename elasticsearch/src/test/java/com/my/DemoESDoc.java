package com.my;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.ShardSearchFailure;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.*;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
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
        client.close();
        System.out.println(indexResponse.toString());
        System.out.println("DemoESDoc.testCreateDoc");
    }

    /**
     * 修改文档 单个字段修改
     *
     * @throws Exception
     */
    @Test
    public void testUpdateOneFieldDoc() throws Exception {
        final String id = "10002";
        RestHighLevelClient client = getEsHighInit();
        GetRequest getRequest = new GetRequest(INDEX_NAME, id);
        getRequest.fetchSourceContext(new FetchSourceContext(false)); //禁用fetching _source.
        boolean exists = client.exists(getRequest, RequestOptions.DEFAULT);
        if (!exists) {
            UserEntity userEntity = new UserEntity();
            userEntity.setAddress("中国-四川-成都");
            userEntity.setAge(RandomUtil.randomInt(1, 100));
            userEntity.setId(Integer.valueOf(id));
            userEntity.setName(RandomUtil.randomString(5));
            userEntity.setUuid(id);
            userEntity.setBirthday(new Date());
            IndexRequest indexRequest = new IndexRequest();
            indexRequest.index(INDEX_NAME).id(userEntity.getUuid());
            indexRequest.source(new ObjectMapper().writeValueAsString(userEntity), XContentType.JSON);
            client.index(indexRequest, RequestOptions.DEFAULT);
        }
        GetRequest request = new GetRequest();
        request.index(INDEX_NAME).id(id);
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        Map<String, Object> objectMap = response.getSourceAsMap();
        CopyOptions copyOptions = new CopyOptions();
        copyOptions.setIgnoreCase(false);
        UserEntity movieEntity = BeanUtil.mapToBean(objectMap, UserEntity.class, false, copyOptions);
        movieEntity.setAge(25);

        //创建修改请求
        UpdateRequest updateRequest = new UpdateRequest();
        //参数1表示所要修改的索引，参数2指定修改文档的id值
        updateRequest.index(INDEX_NAME).id(id);
        //设置请求体，对数据进行修改，参数2表示字段名，参数3表示所要修改的值
        updateRequest.doc(XContentType.JSON, "age", movieEntity.getAge());
        //得到响应结果
        UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(updateResponse.getResult());
        //关闭ES客户端
        client.close();
    }

    /**
     * 修改文档   整个对象修改
     *
     * @throws Exception
     */
    @Test
    public void testUpdateDoc() throws Exception {
        final String id = "10002";
        RestHighLevelClient client = getEsHighInit();
        GetRequest getRequest = new GetRequest(INDEX_NAME, id);
        getRequest.fetchSourceContext(new FetchSourceContext(false)); //禁用fetching _source.
        boolean exists = client.exists(getRequest, RequestOptions.DEFAULT);
        if (!exists) {
            UserEntity userEntity = new UserEntity();
            userEntity.setAddress("中国-四川-成都");
            userEntity.setAge(RandomUtil.randomInt(1, 100));
            userEntity.setId(Integer.valueOf(id));
            userEntity.setName(RandomUtil.randomString(5));
            userEntity.setUuid(id);
            userEntity.setBirthday(new Date());
            IndexRequest indexRequest = new IndexRequest();
            indexRequest.index(INDEX_NAME).id(userEntity.getUuid());
            indexRequest.source(new ObjectMapper().writeValueAsString(userEntity), XContentType.JSON);
            client.index(indexRequest, RequestOptions.DEFAULT);
        }
        GetRequest request = new GetRequest();
        request.index(INDEX_NAME).id(id);
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        Map<String, Object> objectMap = response.getSourceAsMap();
        CopyOptions copyOptions = new CopyOptions();
        copyOptions.setIgnoreCase(false);
        UserEntity movieEntity = BeanUtil.mapToBean(objectMap, UserEntity.class, false, copyOptions);
        movieEntity.setAge(999);

        //创建修改请求
        UpdateRequest updateRequest = new UpdateRequest();
        //参数1表示所要修改的索引，参数2指定修改文档的id值
        updateRequest.index(INDEX_NAME).id(id);
        Map<String, Object> stringObjectMap = BeanUtil.beanToMap(movieEntity);
        updateRequest.doc(JSONUtil.toJsonStr(stringObjectMap), XContentType.JSON);
        //得到响应结果
        UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(updateResponse.getResult());
        //关闭ES客户端
        client.close();
    }

    /**
     * 使用 index 修改
     *
     * @throws Exception
     */
    @Test
    public void testIndexUpdateDoc() throws Exception {
        final String id = "10002";
        RestHighLevelClient client = getEsHighInit();
        GetRequest getRequest = new GetRequest(INDEX_NAME, id);
        getRequest.fetchSourceContext(new FetchSourceContext(false)); //禁用fetching _source.
        boolean exists = client.exists(getRequest, RequestOptions.DEFAULT);
        if (!exists) {
            UserEntity userEntity = new UserEntity();
            userEntity.setAddress("中国-四川-成都");
            userEntity.setAge(RandomUtil.randomInt(1, 100));
            userEntity.setId(Integer.valueOf(id));
            userEntity.setName(RandomUtil.randomString(5));
            userEntity.setUuid(id);
            userEntity.setBirthday(new Date());
            IndexRequest indexRequest = new IndexRequest();
            indexRequest.index(INDEX_NAME).id(userEntity.getUuid());
            indexRequest.source(new ObjectMapper().writeValueAsString(userEntity), XContentType.JSON);
            client.index(indexRequest, RequestOptions.DEFAULT);
        }
        GetRequest request = new GetRequest();
        request.index(INDEX_NAME).id(id);
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        CopyOptions copyOptions = new CopyOptions();
        copyOptions.setIgnoreCase(false);
        UserEntity movieEntity = BeanUtil.mapToBean(response.getSourceAsMap(), UserEntity.class, false, copyOptions);
        movieEntity.setAge(200);

        // Method : Use index API to update
        IndexRequest indexRequest = new IndexRequest(INDEX_NAME);
        indexRequest.id(id);
//        indexRequest.source("age", 200);
        Map<String, Object> stringObjectMap = BeanUtil.beanToMap(movieEntity);
        indexRequest.source(JSONUtil.toJsonStr(stringObjectMap), XContentType.JSON);
        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println("response id: " + indexResponse.getId());
        System.out.println(indexResponse.getResult().name());
        //关闭ES客户端
        client.close();
    }

    /**
     * 获取文档
     *
     * @throws Exception
     */
    @Test
    public void testGetCreateDoc() throws Exception {
        final String id = "10001";
        RestHighLevelClient client = getEsHighInit();
        GetRequest getRequest = new GetRequest(INDEX_NAME, id);
        getRequest.fetchSourceContext(new FetchSourceContext(false)); //禁用fetching _source.
        boolean exists = client.exists(getRequest, RequestOptions.DEFAULT);
        if (!exists) {
            //没有就创建一个
            UserEntity userEntity = new UserEntity();
            userEntity.setAddress("中国-四川-成都");
            userEntity.setAge(RandomUtil.randomInt(1, 100));
            userEntity.setId(Integer.valueOf(id));
            userEntity.setName(RandomUtil.randomString(5));
            userEntity.setUuid(id);
            userEntity.setBirthday(new Date());
            IndexRequest indexRequest = new IndexRequest();
            indexRequest.index(INDEX_NAME).id(userEntity.getUuid());
            //向ES插入数据，必须将其转换成JSON格式
            ObjectMapper mapper = new ObjectMapper();
            String value = mapper.writeValueAsString(userEntity);
            //可以理解为携带的JSON格式的请求体
            indexRequest.source(value, XContentType.JSON);
            IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
            System.out.println(indexResponse.toString());
            System.out.println(indexResponse.getResult()); //CREATED
        }
        GetRequest request = new GetRequest();
        request.index(INDEX_NAME).id(id);
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        Map<String, Object> objectMap = response.getSourceAsMap();
        CopyOptions copyOptions = new CopyOptions();
        copyOptions.setIgnoreCase(false);
        UserEntity movieEntity = BeanUtil.mapToBean(objectMap, UserEntity.class, false, copyOptions);
        System.out.println(movieEntity);

    }

    /**
     * 根据id 检查文档是否创建
     */
    @Test
    public void testCheckDoc() throws Exception {
        RestHighLevelClient client = getEsHighInit();
        final String id = "10001";
        GetRequest getRequest = new GetRequest(
                INDEX_NAME, //索引
                id);    //文档id
        getRequest.fetchSourceContext(new FetchSourceContext(false)); //禁用fetching _source.
        //显式指定将返回的存储字段
//        getRequest.storedFields("_none_");
        boolean exists = client.exists(getRequest, RequestOptions.DEFAULT);
        client.close();
        System.out.println("id:" + id + " " + exists);
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
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(http);
        return restHighLevelClient;
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
