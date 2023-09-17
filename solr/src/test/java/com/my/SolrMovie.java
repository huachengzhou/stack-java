package com.my;

import cn.hutool.core.collection.CollUtil;
import com.solr.entity.MovieEntity;
import com.solr.study.MovieData;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.GroupCommand;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author : chengdu
 * @date :  2023/9/17-09
 **/
public class SolrMovie {

    //https://blog.csdn.net/tianwenxue/article/details/106488356
    //https://blog.csdn.net/qq_37171817/article/details/105385260
    //https://blog.csdn.net/zhufenglonglove/article/details/51518846
    //https://blog.csdn.net/HenryMrZ/article/details/80848471


    String coreName = "movie";
    //设置solr客户端url地址
    String solrUrl = "http://localhost:8983/solr";


    @Test
    public void groupCommand()throws Exception{
        HttpSolrClient solrClient = getHttpSolrClient();
        SolrQuery query = new SolrQuery("*:*");
        query.set("group", "true");
        query.set("group.field", "title");
        List<GroupCommand> groupCommands = solrClient.query(coreName,query).getGroupResponse().getValues();
        if (CollUtil.isNotEmpty(groupCommands)){
            Iterator<GroupCommand> iterator = groupCommands.iterator();
            while (iterator.hasNext()){
                GroupCommand groupCommand = iterator.next();
                System.out.println(groupCommand.getName());
                System.out.println(groupCommand.getNGroups());
            }
        }

    }

    /**
     * solr查询总数量
     * @throws Exception
     */
    @Test
    public void getCount() throws Exception {
        HttpSolrClient solrClient = getHttpSolrClient();
        List<MovieEntity> movieEntityList = MovieData.getMovieEntityList();
        System.out.println(movieEntityList.size());
        SolrQuery params = new SolrQuery();
        params.set("q", "*:*");
        params.set("start", "0");
        params.set("rows", "0");
        QueryResponse rsp = solrClient.query(coreName,params);
        SolrDocumentList docs = rsp.getResults();
        long num = docs.getNumFound();
        System.out.println(num);
        Assert.assertTrue("不相等",movieEntityList.size() == num);
    }


    /**
     * 批量添加
     *
     * @throws Exception
     */
    @Test
    public void batchInsertMovie() throws Exception {
        //1.创建连接
        HttpSolrClient solrClient = getHttpSolrClient();
        List<MovieEntity> movieEntityList = MovieData.getMovieEntityList();

        for (MovieEntity movieEntity : movieEntityList) {
            //2.创建一个文档对象
            SolrInputDocument solrInputFields = new SolrInputDocument();
            solrInputFields.addField("episodes_info", movieEntity.getEpisodes_info());
            solrInputFields.addField("rate", movieEntity.getRate());
            solrInputFields.addField("cover_x", movieEntity.getCover_x());
            solrInputFields.addField("title", movieEntity.getTitle());
            solrInputFields.addField("url", movieEntity.getUrl());
            solrInputFields.addField("playable", movieEntity.isPlayable());
            solrInputFields.addField("cover", movieEntity.getCover());
            solrInputFields.addField("id", movieEntity.getId());
            solrInputFields.addField("cover_y", movieEntity.getCover_y());
            solrInputFields.addField("is_new", movieEntity.is_new());
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
