package com.select;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Description
 * @createDate 2019/1/1
 **/
public class ParseDemo {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testParseOne() throws MalformedURLException, IOException {
        Document doc = Jsoup.parse(new URL("http://www.funi.com/"), 7000);
    }

    @Test
    public void testBody() {
        String html = "<div><p>Lorem ipsum.</p>";
        Document doc = Jsoup.parseBodyFragment(html);

        Element body = doc.body();
        System.out.println(body.html());
    }

    @Test
    public void testParseURL() throws Exception {
        Document doc = Jsoup.parse(new URL("http://www.funi.com/"), 6000);

        Document doc2 = Jsoup.connect("http://www.funi.com/")
//                .data("query", "Java")
                .userAgent("Mozilla")
                .cookie("auth", "token")
                .timeout(3000)
                .get();
        System.out.println(doc2.title());
    }

    @Test
    public void foreachElement() throws Exception {
        Document doc = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.funi.com/");
        //使用chrome 头伪装
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36");
        //设置基本的配置
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(5000) // 设置连接超时时间 5秒钟
                .setSocketTimeout(4000) // 设置读取超时时间4秒钟
                .build();
        httpGet.setConfig(config);

        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity == null) {
                return;
            }
            String html = EntityUtils.toString(httpEntity, "utf-8");
            if (StringUtils.isNotEmpty(html)) {
                doc = Jsoup.parse(html);
            }
        } catch (Exception e) {
            logger.error("获取html失败!", e);
        } finally {
            //关闭处理
            httpResponse.close();
            httpClient.close();
        }
        Element body = doc.body();
        Elements foot = body.getElementsByClass("foot").first().getElementsByClass("footer clearfix").first().getElementsByTag("dl");
        for (Element ele : foot) {
            System.out.println(ele.html());
            for (int i = 0; i < 20; i++) {
                System.out.print('.');
            }
        }
    }

    @Test
    public void testSelect() throws Exception {
        Document doc = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.stats.gov.cn/");
        //使用chrome 头伪装
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36");
        //设置基本的配置
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(5000) // 设置连接超时时间 5秒钟
                .setSocketTimeout(4000) // 设置读取超时时间4秒钟
                .build();
        httpGet.setConfig(config);
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();

            String html = EntityUtils.toString(httpEntity, "utf-8");
            if (StringUtils.isNotEmpty(html)) {
                doc = Jsoup.parse(html);
            }
        } catch (Exception e) {
            logger.error("获取html失败!", e);
        } finally {
            // 关闭处理
            httpResponse.close();
            httpClient.close();
        }
        Element body = doc.body();
        Elements selects = body.select(".center div:eq(0) ul li:lt(3)");

        for (Element ele : selects) {
            System.out.println(ele);
        }
    }

}
