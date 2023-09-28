package com.my;

import cn.hutool.core.util.RandomUtil;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.CoreAdminRequest;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.util.Arrays;
import java.util.UUID;

/**
 * @author : chengdu
 * @date :  2023/9/18-09
 **/
public class SolrMergeTestSchool {

    String coreA = "merge_a";
    String coreB = "merge_b";
    String coreAB = "merge_ab";
    //设置solr客户端url地址
    String solrUrl = "http://localhost:8983/solr";


    @Test
    public void testCreateMergeAB() throws Exception {
        //1.创建连接
        HttpSolrClient solrClient = getHttpSolrClient();

        //清除数据
        solrClient.deleteByQuery(coreAB, "*:*");
        solrClient.commit(coreAB, true, true);
        System.out.println("clear ");

        long startMillis = System.currentTimeMillis();
        CoreAdminRequest.MergeIndexes mergeIndex = new CoreAdminRequest.MergeIndexes();
        mergeIndex.setCoreName(coreAB);
        mergeIndex.setSrcCores(Arrays.asList(coreA, coreB));
        solrClient.request(mergeIndex);
        solrClient.commit(coreAB, true, true);
        solrClient.close();
        long range = System.currentTimeMillis() - startMillis;
        System.out.println("range:" + range + " " + (range / 1000) + "秒");
    }


    @Test
    public void testCreateMergeA() throws Exception {
        //1.创建连接
        HttpSolrClient solrClient = getHttpSolrClient();

        //清除数据
        solrClient.deleteByQuery(coreA, "*:*");
        solrClient.commit(coreA, true, true);

        final long size = 3000000;
        for (int i = 0; i < size / 1000; i++) {
            System.out.println("i:" + i);
            for (int j = 0; j < 1000; j++) {
                SolrInputDocument solrInputFields = new SolrInputDocument();
                solrInputFields.addField("id", RandomUtil.randomNumbers(30));
                solrInputFields.addField("uuid", UUID.randomUUID().toString());
                solrInputFields.addField("year", RandomUtil.randomInt(1, 100));
                solrInputFields.addField("fraction", RandomUtil.randomInt(60, 100));
                solrInputFields.addField("maxScore", RandomUtil.randomInt(90, 100));
                solrInputFields.addField("minScore", RandomUtil.randomInt(10, 60));
                solrInputFields.addField("enrollment", "");
                solrInputFields.addField("province", RandomUtil.randomBoolean() ? "四川" : "北京");
                solrInputFields.addField("type", RandomUtil.randomBoolean() ? "理工" : "文学");
                solrInputFields.addField("primaryClassification", "");
                solrInputFields.addField("method", "统招");
                solrInputFields.addField("speciality", RandomUtil.randomBoolean() ? "理学与材料菁英班" : "电子信息工程（实验班）");
                solrInputFields.addField("sourceText", "");
                solrInputFields.addField("school", RandomUtil.randomBoolean() ? "四川大学" : "成都理工大学");
                solrInputFields.addField("batch", "本科第一批");
                solrInputFields.addField("typeEnum", "ADMISSION_BIT_EDU_CN");
                solrInputFields.addField("remark", UUID.randomUUID().toString());
                solrInputFields.addField("gmtCreated", "");
                solrInputFields.addField("gmtModified", "");

                solrClient.add(coreA, solrInputFields);
            }

            //4.提交
            solrClient.commit(coreA, true, true);
        }


        solrClient.close();
    }

    @Test
    public void testCreateMergeB() throws Exception {
        //1.创建连接
        HttpSolrClient solrClient = getHttpSolrClient();

        //清除数据
        solrClient.deleteByQuery(coreB, "*:*");
        solrClient.commit(coreB, true, true);

        final long size = 3000000;
        for (int i = 0; i < size / 1000; i++) {
            System.out.println("i:" + i);
            for (int j = 0; j < 1000; j++) {
                SolrInputDocument solrInputFields = new SolrInputDocument();
                solrInputFields.addField("id", RandomUtil.randomNumbers(30));
                solrInputFields.addField("uuid", UUID.randomUUID().toString());
                solrInputFields.addField("year", RandomUtil.randomInt(1, 100));
                solrInputFields.addField("fraction", RandomUtil.randomInt(60, 100));
                solrInputFields.addField("maxScore", RandomUtil.randomInt(90, 100));
                solrInputFields.addField("minScore", RandomUtil.randomInt(10, 60));
                solrInputFields.addField("enrollment", "");
                solrInputFields.addField("province", RandomUtil.randomBoolean() ? "四川" : "北京");
                solrInputFields.addField("type", RandomUtil.randomBoolean() ? "理工" : "文学");
                solrInputFields.addField("primaryClassification", "");
                solrInputFields.addField("method", "统招");
                solrInputFields.addField("speciality", RandomUtil.randomBoolean() ? "理学与材料菁英班" : "电子信息工程（实验班）");
                solrInputFields.addField("sourceText", "");
                solrInputFields.addField("school", RandomUtil.randomBoolean() ? "四川大学" : "成都理工大学");
                solrInputFields.addField("batch", "本科第一批");
                solrInputFields.addField("typeEnum", "ADMISSION_BIT_EDU_CN");
                solrInputFields.addField("remark", UUID.randomUUID().toString());
                solrInputFields.addField("gmtCreated", "");
                solrInputFields.addField("gmtModified", "");

                solrClient.add(coreB, solrInputFields);
            }

            //4.提交
            solrClient.commit(coreB, true, true);
        }


        solrClient.close();
    }


    private HttpSolrClient getHttpSolrClient() {
        return new HttpSolrClient.Builder(solrUrl).withConnectionTimeout(1000 * 60 * 60).withSocketTimeout(1000 * 60 * 60)
                .build();
    }

}
