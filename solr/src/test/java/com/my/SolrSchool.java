package com.my;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.solr.entity.SchoolFractionInfo;
import com.solr.study.SchoolFractionInfoData;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author : chengdu
 * @date :  2023/9/18-09
 **/
public class SolrSchool {

    String coreName = "myIndex";
    //设置solr客户端url地址
    String solrUrl = "http://localhost:8983/solr";

    @Test
    public void test1() {
        Field[] declaredFields = SchoolFractionInfo.class.getDeclaredFields();
        final String template = " solrInputFields.addField(\"{field}\", ReflectUtil.getFieldValue(schoolFractionInfo,\"{field}\"));";
        for (Field field : declaredFields) {
            String replace = StrUtil.replace(template, "{field}", field.getName());
            System.out.println(replace);
        }
    }


    @Test
    public void test2() throws Exception {
        //1.创建连接
        HttpSolrClient solrClient = getHttpSolrClient();
        List<SchoolFractionInfo> schoolFractionInfoList = SchoolFractionInfoData.getSchoolFractionInfoList();
        for (SchoolFractionInfo schoolFractionInfo : schoolFractionInfoList) {
            //2.创建一个文档对象
            SolrInputDocument solrInputFields = new SolrInputDocument();
            solrInputFields.addField("id", ReflectUtil.getFieldValue(schoolFractionInfo, "id"));
            solrInputFields.addField("uuid", ReflectUtil.getFieldValue(schoolFractionInfo, "uuid"));
            solrInputFields.addField("year", ReflectUtil.getFieldValue(schoolFractionInfo, "year"));
            solrInputFields.addField("fraction", ReflectUtil.getFieldValue(schoolFractionInfo, "fraction"));
            solrInputFields.addField("maxScore", ReflectUtil.getFieldValue(schoolFractionInfo, "maxScore"));
            solrInputFields.addField("minScore", ReflectUtil.getFieldValue(schoolFractionInfo, "minScore"));
            solrInputFields.addField("enrollment", ReflectUtil.getFieldValue(schoolFractionInfo, "enrollment"));
            solrInputFields.addField("province", ReflectUtil.getFieldValue(schoolFractionInfo, "province"));
            solrInputFields.addField("type", ReflectUtil.getFieldValue(schoolFractionInfo, "type"));
            solrInputFields.addField("primaryClassification", ReflectUtil.getFieldValue(schoolFractionInfo, "primaryClassification"));
            solrInputFields.addField("method", ReflectUtil.getFieldValue(schoolFractionInfo, "method"));
            solrInputFields.addField("speciality", ReflectUtil.getFieldValue(schoolFractionInfo, "speciality"));
            solrInputFields.addField("sourceText", ReflectUtil.getFieldValue(schoolFractionInfo, "sourceText"));
            solrInputFields.addField("school", ReflectUtil.getFieldValue(schoolFractionInfo, "school"));
            solrInputFields.addField("batch", ReflectUtil.getFieldValue(schoolFractionInfo, "batch"));
            solrInputFields.addField("typeEnum", ReflectUtil.getFieldValue(schoolFractionInfo, "typeEnum"));
            solrInputFields.addField("remark", ReflectUtil.getFieldValue(schoolFractionInfo, "remark"));
            solrInputFields.addField("gmtCreated", ReflectUtil.getFieldValue(schoolFractionInfo, "gmtCreated"));
            solrInputFields.addField("gmtModified", ReflectUtil.getFieldValue(schoolFractionInfo, "gmtModified"));

            solrClient.add(coreName, solrInputFields);
        }

        //4.提交
        solrClient.commit(coreName, true, true);
        solrClient.close();
    }


    private HttpSolrClient getHttpSolrClient() {
        return new HttpSolrClient.Builder(solrUrl)
                .build();
    }

}
