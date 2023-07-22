package com.my;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : chengdu
 * @date :  2023/7/22-07
 **/
public class DemoESClient {

    private final Logger logger = LoggerFactory.getLogger(getClass()) ;

    /**
     * 简单客户端
     * @throws Exception
     */
    @Test
    public void execute()throws Exception{
        RestHighLevelClient client = getRestHighLevelClient();

        logger.info("sucess!");

        client.close();
    }


    /**
     * 使用id获取数据
     * @throws Exception
     */
    @Test
    public void testGet()throws Exception{
        RestHighLevelClient client = getRestHighLevelClient();
        GetRequest request = new GetRequest() ;
        request.index("user").id("1");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        System.out.println(response.getSourceAsString());

        System.out.println("DemoESClient.testGet"+request.id());
    }

    private RestHighLevelClient getRestHighLevelClient() {
        return new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );
    }

}
