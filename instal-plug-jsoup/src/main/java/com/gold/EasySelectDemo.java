package com.gold;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @createDate 2018/12/31
 **/

public class EasySelectDemo {

    @Test
    public void selectThree()throws Exception{
        HttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("https://www.cnblogs.com/");
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36");
        HttpResponse httpResponse = null;

        httpResponse = httpClient.execute(httpPost);
        if (httpResponse == null) {
            return;
        }
        HttpEntity httpEntity = httpResponse.getEntity();
        if (httpEntity == null) {
            return;
        }
        String webHtml = EntityUtils.toString(httpEntity, "utf-8");
        if (StringUtils.isEmpty(webHtml)) {
            return;
        }

        Document doc = Jsoup.parse(webHtml);

        Elements friendLinks = doc.select("#friend_link").first().select("a");
        //获取属性
        for (Element ele:friendLinks){
            System.out.println("html:"+ele.html());
            System.out.println("target:"+ele.attr("target"));
            System.out.println("href:"+ele.attr("href"));
            System.out.println();
        }
    }

    @Test
    public void selectTwo()throws IOException{
        HttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("https://www.cnblogs.com/");
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36");
        HttpResponse httpResponse = null;

        httpResponse = httpClient.execute(httpPost);
        if (httpResponse == null) {
            return;
        }
        HttpEntity httpEntity = httpResponse.getEntity();
        if (httpEntity == null) {
            return;
        }
        String webHtml = EntityUtils.toString(httpEntity, "utf-8");
        if (StringUtils.isEmpty(webHtml)) {
            return;
        }

        Document doc = Jsoup.parse(webHtml);

        Elements linkElements = doc.select("#side_nav ul li a");
        for (Element link :linkElements){
//            System.out.println("nav:"+link.text());
        }

        //获取a标签所有带href属性的元素
        Elements aLink = doc.select("a[href]");
        for (Element a:aLink){
//            System.out.println(a.text());
        }

        //jquery 方式来选择
        Elements post_list = doc.select("#post_list .post_item .post_item_body > p");
        for (Element ele:post_list){
            System.out.println(ele.text());
            System.out.println("==============================================");
        }

        //获取png结尾的图片
        Elements pngS = doc.select("img[src$=.png]");
        for (Element png:pngS){
            System.out.println(png.toString());
        }
    }

    @Test
    public void selectOne() {
        /*
        *   getElementById(String id) 根据 id 来查询 DOM
            getElementsByTag(String tagName) 根据 tag 名称来查询 DOM
            getElementsByClass(String className) 根据样式名称来查询 DOM
            getElementsByAttribute(String key) 根据属性名来查询 DOM
            getElementsByAttributeValue(String key,String value) 根据属性名和属性值来查询 DOM
        * */
        HttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("https://www.cnblogs.com/");
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36");
        HttpResponse httpResponse = null;

        try {
            httpResponse = httpClient.execute(httpPost);
            if (httpResponse == null) {
                return;
            }
            HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity == null) {
                return;
            }
            String webHtml = EntityUtils.toString(httpEntity, "utf-8");
            if (StringUtils.isEmpty(webHtml)) {
                return;
            }

            Document doc = Jsoup.parse(webHtml);

            Element nav = doc.getElementById("side_nav");

            Element cate_item = nav.getElementById("cate_item");

            Elements lis = cate_item.getElementsByTag("li");
            for (Element e : lis) {
//                System.out.println(e.text());
            }

            Elements aList = doc.getElementsByTag("a");
            for (Element e : aList) {
//                System.out.println(e.text());
            }

            Elements r_l_3 = doc.getElementsByClass("r_l_3");
            for (Element element : r_l_3) {
//                System.out.println(element.toString());
            }

            Elements widths = doc.getElementsByAttribute("width");
            widths.forEach(element -> {
//                System.out.println(element.toString());
            });

            Elements targetElements  =doc.getElementsByAttributeValue("target","_blank");
            for (Element ee:targetElements){
                System.out.println(ee.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
