package com.my;

import cn.hutool.json.JSONUtil;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.MapSolrParams;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

/*
solr create -c zch[admin]
create -c admin
solr create -c admin
solr create -c product
* */


public class SolrClient {
    String coreName = "zch";
    //设置solr客户端url地址

    String solrUrl = "http://localhost:8983/solr";

    @Test
    public void testHttpSolrClient() throws Exception {
        HttpSolrClient solrClient = getHttpSolrClient();
        System.out.println(solrClient);
    }


    @Test
    public void testHttpSolrClientQuery() throws Exception {
        HttpSolrClient solrClient = getHttpSolrClient();
        Map<String, String> map = new HashMap<>();
        //查询条件
        map.put("q", "*:*");
        //要显示的内容
        map.put("fl", "id,age,name,poems");
        //排序方式
        map.put("sort", "id asc");
        MapSolrParams solrParams = new MapSolrParams(map);

        QueryResponse queryResponse = solrClient.query(coreName, solrParams);
        SolrDocumentList documents = queryResponse.getResults();
        System.out.println("查询到{}个文档！" + documents.getNumFound());
        for (SolrDocument document : documents) {

            System.out.println(JSONUtil.toJsonStr(document));

            String id = (String) document.getFieldValue("id");
            String age = String.valueOf(document.getFieldValue("age"));
            String name = String.valueOf(document.getFieldValue("name"));
            String poems = String.valueOf(document.getFieldValue("poems"));
            System.out.println(id + age + name + poems);
        }
    }

    @Test
    public void deleteOneDoc() throws Exception {
        HttpSolrClient solrClient = getHttpSolrClient();
        solrClient.deleteByQuery(coreName, "dataType:BomBaseVoucher");
        UpdateResponse response = solrClient.commit(coreName, true, true);
        System.out.println(response._size());
        System.out.println(response.getStatus());
    }

    @Test
    public void deleteQueryDoc() throws Exception {

    }

    @Test
    public void addOneDoc() throws Exception {
        HttpSolrClient solrClient = getHttpSolrClient();

        SolrInputDocument document = new SolrInputDocument();
        document.addField("id", UUID.randomUUID().toString());
        document.addField("age", 30);
        document.addField("name", "李白3");
        document.addField("poems", "望庐山瀑布");
        document.addField("about", "字太白");
        document.addField("dataType", "BomBaseVoucher");


        solrClient.add(coreName, document);
        solrClient.commit(coreName, true, true);
    }


    @Test
    public void update() throws IOException, SolrServerException {
        //创建solrClient同时指定超时时间，不指定走默认配置
        HttpSolrClient solrClient = getHttpSolrClient();


        SolrInputDocument document = new SolrInputDocument();
        document.addField("id", "123456");
        document.addField("age", 30);
        document.addField("name", "李白2");
        document.addField("poems", "望庐山瀑布");
        document.addField("about", "字太白");
        document.addField("success", "创造了古代浪漫主义文学高峰、歌行体和七绝达到后人难及的高度");

        SolrInputDocument document2 = new SolrInputDocument();
        document2.addField("id", "123457");
        document2.addField("age", 31);
        document2.addField("name", "杜甫");
        document2.addField("poems", "望岳");
        document2.addField("about", "字子美");
        document2.addField("success", "唐代伟大的现实主义文学作家，唐诗思想艺术的集大成者");

        solrClient.add(coreName, document);
        solrClient.add(coreName, document2);
        solrClient.commit(coreName, true, true);
    }

    private HttpSolrClient getHttpSolrClient() {
        return new HttpSolrClient.Builder(solrUrl)
                .withConnectionTimeout(10000)
                .withSocketTimeout(60000)
                .build();
    }

}
