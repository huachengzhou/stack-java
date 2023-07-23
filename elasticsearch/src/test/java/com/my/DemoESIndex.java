package com.my;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.*;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author : chengdu
 * @date :  2023/7/23-07
 **/
public class DemoESIndex {
    public static final int CONNECT_TIMEOUT = 700000;
    public static final int SOCKET_TIMEOUT = 600000;
    public static final int CONNECTION_REQUEST_TIMEOUT = 100000;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    public static final String LOCALHOST = "localhost";
    public static final int PORT = 9200;
    public static final String SCHEME = "http";

    /**
     * 获取所有索引
     *
     * @throws Exception
     */
    @Test
    public void testGetAllIndex() throws Exception {
        RestHighLevelClient client = getRestHighLevelClient();
        GetAliasesRequest aliasesRequest = new GetAliasesRequest();
        GetAliasesResponse aliasesResponse = client.indices().getAlias(aliasesRequest, RequestOptions.DEFAULT);
        Set<String> indexSet = aliasesResponse.getAliases().keySet();

        logger.info("获取所有索引");
        indexSet.forEach(s -> logger.info(s));
    }

    /**
     * 创建索引
     *
     * @throws Exception
     */
    @Test
    public void testCreateIndex() throws Exception {
        RestHighLevelClient client = getRestHighLevelClient();
        IndicesClient indicesClient = client.indices();
        String uuid = UUID.fastUUID().toString();
        System.out.println("索引创建:" + uuid);

        CreateIndexRequest request = new CreateIndexRequest(uuid);
        CreateIndexResponse createIndexResponse = indicesClient.create(request, RequestOptions.DEFAULT);
        // 响应状态
        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println("索引操作" + acknowledged);
    }


    /**
     * 索引获取
     * @throws Exception
     */
    @Test
    public void testSearchIndex()throws Exception{
        RestHighLevelClient client = getEsHighInit();
        IndicesClient indicesClient = client.indices();

        String[] strings = {"40a1313b-e86b-4860-b55f-b7ddae7a6a6a", "cfa2dbdf-681d-4231-98a6-7ecae12fc594"};
        GetIndexRequest getIndexRequest = new GetIndexRequest(strings);

        GetIndexResponse getIndexResponse = indicesClient.get(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println(getIndexResponse.getIndices());
        System.out.println(getIndexResponse.getMappings());
        System.out.println(getIndexResponse.getSettings());
    }


    /**
     * 索引删除
     * @throws Exception
     */
    @Test
    public void testDeleteIndex()throws Exception{
        RestHighLevelClient client = getEsHighInit();
        IndicesClient indicesClient = client.indices();
        String[] strings = {"40a1313b-e86b-4860-b55f-b7ddae7a6a6a", "cfa2dbdf-681d-4231-98a6-7ecae12fc594"};
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest();
        deleteIndexRequest.indices(strings);
        AcknowledgedResponse response = indicesClient.delete(deleteIndexRequest, RequestOptions.DEFAULT);

        // 响应状态
        System.out.println("索引操作" +response.isAcknowledged());

    }

    private RestHighLevelClient getRestHighLevelClient() {
        return new RestHighLevelClient(
                RestClient.builder(new HttpHost(LOCALHOST, PORT, SCHEME))
        );
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

}
