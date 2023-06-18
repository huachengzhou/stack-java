package com.gold;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
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
import tool.utils.word.aspose.AsposeUtils;

import java.io.IOException;
import java.util.UUID;

/**
 * @Description
 * @createDate 2018/12/30
 **/
public class HelloWorld {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void test() throws IOException {
        HttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("https://www.cnblogs.com/");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36");
        HttpResponse httpResponse = httpClient.execute(httpGet);

        HttpEntity httpEntity = httpResponse.getEntity();
        String html = EntityUtils.toString(httpEntity, "utf-8");

        Document document = Jsoup.parse(html);
        Elements elements = document.getElementsByTag("title");
        Element titleElement = elements.first();

        System.out.println(titleElement.text());

        Element site_nav_top = document.getElementById("site_nav_top");
        System.out.println("口号:" + site_nav_top.text());
    }

    @Test
    public void getOneElement() throws Exception {
        Document doc = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://zhuanlan.zhihu.com/p/81306458");
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
        Element first = body.getElementsByClass("Post-RichTextContainer").first();
        com.aspose.words.Document doc2 = new com.aspose.words.Document();
        com.aspose.words.DocumentBuilder builder = new com.aspose.words.DocumentBuilder(doc2);
        builder.insertHtml(first.html());
        AsposeUtils.checkLicense();
        String dir = "E:\\data\\"+ UUID.randomUUID().toString().substring(0,7)+".doc";
        System.out.println(dir);
        AsposeUtils.saveWord(dir, doc2);

    }

}
