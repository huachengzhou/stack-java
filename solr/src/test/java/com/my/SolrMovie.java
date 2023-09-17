package com.my;

import com.solr.entity.MovieEntity;
import com.solr.study.MovieData;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.util.ArrayList;
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
            solrClient.add(coreName,solrInputFields);
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
