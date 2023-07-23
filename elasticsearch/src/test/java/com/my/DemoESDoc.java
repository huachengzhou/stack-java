package com.my;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.*;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

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
        userEntity.setAge(RandomUtil.randomInt(1,100));
        userEntity.setId(RandomUtil.randomInt(1000000,2000000));
        userEntity.setName(RandomUtil.randomString(5));
        userEntity.setUuid(UUID.fastUUID().toString());

        IndexRequest indexRequest = new IndexRequest();
        indexRequest.index(INDEX_NAME).id(userEntity.getUuid()) ;

        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(userEntity);
        indexRequest.source(userJson, XContentType.JSON);

        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse.toString());


        System.out.println("DemoESDoc.testCreateDoc");
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
