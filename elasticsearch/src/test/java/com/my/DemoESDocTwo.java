package com.my;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.entity.MovieEntity;
import com.my.study.MovieData;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.*;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.ShardSearchFailure;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.*;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.Strings;
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

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author : chengdu
 * @date :  2023/7/23-07
 **/
public class DemoESDocTwo {
    //https://blog.csdn.net/weixin_45417821/category_11079267.html

    private static final int CONNECT_TIMEOUT = 700000;
    private static final int SOCKET_TIMEOUT = 600000;
    private static final int CONNECTION_REQUEST_TIMEOUT = 100000;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static final String LOCALHOST = "localhost";
    private static final int PORT = 9200;
    private static final String SCHEME = "http";

    private static final String INDEX_NAME = "movie";

    private ThreadLocal<Boolean> IndexBoolean = new ThreadLocal<>();


    /**
     * 批量添加
     */
    @Test
    public void testCreateBatchDoc() throws Exception {
        RestHighLevelClient client = getEsHighInit();
        // 批量插入数据
        BulkRequest bulkRequest = new BulkRequest();
        List<MovieEntity> movieEntityList = MovieData.getMovieEntityList();
        int initialCapacity = movieEntityList.size();
        ObjectMapper mapper = new ObjectMapper();
        for (int i = 0; i < initialCapacity; i++) {
            MovieEntity movieEntity = movieEntityList.get(i);
            bulkRequest.add(new IndexRequest().index(INDEX_NAME).id(movieEntity.getId()).source(mapper.writeValueAsString(movieEntity), XContentType.JSON));
        }
        BulkResponse bulk = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulk.toString());
        for (BulkItemResponse item : bulk.getItems()) {
            System.out.println(" 第:" + item.getItemId() + " execute:" + item.getOpType() + " 索引:" + item.getIndex() + " type:" + item.getType() + " id:" + item.getId());
        }
        client.close();
    }

    /**
     * 批量删除
     *
     * @throws Exception
     */
    @Test
    public void testDeleteBatchDoc() throws Exception {
        RestHighLevelClient client = getEsHighInit();
        BulkRequest bulkRequest = new BulkRequest();
        List<MovieEntity> movieEntityList = MovieData.getMovieEntityList();
        int initialCapacity = movieEntityList.size();
        for (int i = 0; i < initialCapacity; i++) {
            MovieEntity movieEntity = movieEntityList.get(i);
            bulkRequest.add(new DeleteRequest().index(INDEX_NAME).id(movieEntity.getId()));
        }
        BulkResponse bulk = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulk.toString());
        for (BulkItemResponse item : bulk.getItems()) {
            System.out.println(" 第:" + item.getItemId() + " execute:" + item.getOpType() + " 索引:" + item.getIndex() + " type:" + item.getType() + " id:" + item.getId());
        }
        client.close();
    }

    /**
     * 批量用id获取
     *
     * @throws Exception
     */
    @Test
    public void testGetBatchDoc() throws Exception {
        RestHighLevelClient client = getEsHighInit();
        MultiGetRequest request = new MultiGetRequest();
        Field[] declaredFields = MovieEntity.class.getDeclaredFields();
        String[] includes = new String[declaredFields.length];
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            includes[i] = field.getName();
        }
        String[] excludes = Strings.EMPTY_ARRAY;
        FetchSourceContext fetchSourceContext = new FetchSourceContext(true, includes, excludes);
        List<MovieEntity> movieEntityList = MovieData.getMovieEntityList();
        int initialCapacity = movieEntityList.size();
        for (int i = 0; i < initialCapacity; i++) {
            MovieEntity movieEntity = movieEntityList.get(i);
            request.add(new MultiGetRequest.Item(INDEX_NAME, movieEntity.getId()).fetchSourceContext(fetchSourceContext));
        }
        MultiGetResponse response = client.mget(request, RequestOptions.DEFAULT);
        for (MultiGetItemResponse itemResponse : response.getResponses()) {
            GetResponse responseResponse = itemResponse.getResponse();
            Map<String, Object> source = responseResponse.getSource();
            if (source.isEmpty()) {
                continue;
            }
            CopyOptions copyOptions = new CopyOptions();
            copyOptions.setIgnoreCase(false);
            MovieEntity movieEntity = BeanUtil.mapToBean(source, MovieEntity.class, false, copyOptions);
            if (movieEntity != null) {
                System.out.println(movieEntity);
            }
        }
    }

    /**
     * 查询索引下的所有文档
     *
     * @throws Exception
     */
    @Test
    public void testGetAllDoc() throws Exception {
        RestHighLevelClient client = getEsHighInit();
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);
        //可以指定type,也可以不指定，不指定查所有
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = searchResponse.getHits();
        long totalHits = hits.getTotalHits().value;
        //匹配查询的结果集
        SearchHit[] searchHits = hits.getHits();
        for (SearchHit hit : searchHits) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            CopyOptions copyOptions = new CopyOptions();
            copyOptions.setIgnoreCase(false);
            MovieEntity movieEntity = BeanUtil.mapToBean(sourceAsMap, MovieEntity.class, false, copyOptions);
            if (movieEntity != null) {
                System.out.println(movieEntity);
            }
        }
    }

    /**
     * 批量更新
     * @throws Exception
     */
    @Test
    public void testUpdateBatchDoc() throws Exception {
        RestHighLevelClient client = getEsHighInit();
        BulkRequest bulkRequest = new BulkRequest();
        List<MovieEntity> movieEntityList = MovieData.getMovieEntityList();
        int initialCapacity = movieEntityList.size();
        for (int i = 0; i < initialCapacity; i++) {
            MovieEntity movieEntity = movieEntityList.get(i);
            if (StrUtil.isNotBlank(movieEntity.getRate())) {
                if (NumberUtil.isNumber(movieEntity.getRate())) {
                    BigDecimal bigDecimal = NumberUtil.add(movieEntity.getRate(), "0.1");
                    movieEntity.setRate(bigDecimal.setScale(2).toPlainString());
                }
            }
            UpdateRequest request = new UpdateRequest();
            request.index(INDEX_NAME);
            request.doc(BeanUtil.beanToMap(movieEntity)).id(movieEntity.getId());
            bulkRequest.add(request);
            bulkRequest.add(request);
        }
        BulkResponse bulk = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulk.toString());
        for (BulkItemResponse item : bulk.getItems()) {
            System.out.println(" 第:" + item.getItemId() + " execute:" + item.getOpType() + " 索引:" + item.getIndex() + " type:" + item.getType() + " id:" + item.getId());
        }
        client.close();
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


}
