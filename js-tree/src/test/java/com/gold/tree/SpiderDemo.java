package com.gold.tree;

import com.gold.tree.entiyi.MarkdownSavePipeline;
import com.gold.tree.entiyi.RunoobPageProcessor;
import org.junit.Test;
import us.codecraft.webmagic.Spider;

/**
 * Created by Lenovo on 2020/8/16.
 */
public class SpiderDemo {

    @Test
    public void testA(){
//        String url = "http://www.runoob.com/regexp/regexp-tutorial.html";
        String url = "http://www.runoob.com/scala/scala-tutorial.html";
        //爬虫控制器   添加页面解析                添加url(request)     添加持久化组件               创建线程   执行
        Spider.create(new RunoobPageProcessor()).addUrl(url).addPipeline(new MarkdownSavePipeline()).thread(1).run();
    }


}
