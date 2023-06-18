package com.gold;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

/**
 * @createDate 2018/12/31
 **/
public class ChengDuEstateGet {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private Document getDocument(String uri) throws IOException {
        Document doc = null;
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(uri);
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36");
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(5000) // 设置连接超时时间 3秒钟
                .setSocketTimeout(4000) // 设置读取超时时间4秒钟
                .build();
        httpGet.setConfig(config);
        HttpResponse httpResponse = null;

        httpResponse = httpClient.execute(httpGet);
        if (httpResponse == null) {
            return null;
        }
        HttpEntity httpEntity = httpResponse.getEntity();
        if (httpEntity == null) {
            return null;
        }
        String webHtml = EntityUtils.toString(httpEntity, "utf-8");
        if (StringUtils.isEmpty(webHtml)) {
            return null;
        }
        doc = Jsoup.parse(webHtml);
        return doc;
    }

    @Test
    public void start() throws IOException {
        String region = "http://www.funi.com/loupan/region_0_0_0_0_";
        String uri = String.format("%s%d", region, 1);
        Document doc = getDocument(uri);
        Integer pageMax = 0;
        //选择出导航div
        Elements pages = doc.getElementsByTag("body").first().getElementsByClass("wraper").first().select(".main .newhouse .pages");
        //获取最后一个
        Element last = pages.first().select("a").last();
        //获取last上一个 元素
        Element pageElement = last.previousElementSibling();
        String pageText = pageElement.text();
        if (StringUtils.isNotEmpty(pageText)) {
            if (org.apache.commons.lang.math.NumberUtils.isNumber(pageText)) {
                pageMax = Integer.parseInt(pageText);
                if (pageMax.intValue() >= 1) {
                    for (int i = 1; i < pageMax; i++) {
                        uri = String.format("%s%d", region, i);
                        Document document = getDocument(uri);
                        if (document != null) {
                            test(document, i);
                            System.out.println(uri);
                        }
                    }
                }
            }
        }
    }

    private void test(Document document, Integer page) {
        StringBuilder builder = new StringBuilder();
        Elements mapList = document.getElementsByTag("body").first().getElementsByClass("wraper").first().getElementsByClass("main").first().getElementsByClass("newhouse clearfix").first().select(".fleft .maplist dl");
        for (Element ele : mapList) {
            BigDecimal lng = null;
            BigDecimal lat = null;
            BigInteger fid = null;
            try {
                lng = new BigDecimal(ele.attr("lng"));
                lat = new BigDecimal(ele.attr("lat"));
                fid = new BigInteger(ele.attr("fid"));
                builder.append("lng:").append(lng).append(";").append(" ");
                builder.append("lat:").append(lat).append(";").append(" ");
                builder.append("fid:").append(fid).append(";").append(" ");
            } catch (NumberFormatException e) {
                //可能有数字的
                builder.append("lng:").append(lng).append(";").append(" ");
                builder.append("lat:").append(lat).append(";").append(" ");
                builder.append("fid:").append(fid).append(";").append(" ");
            }
            for (int i = 0; i < 20; i++) {
                builder.append('.');
            }
            builder.append("\n");
        }
        String path = String.format("%s%s%s", "D:\\cache\\test\\getData\\", UUID.randomUUID().toString().substring(1, 6) + "_" + page, ".txt");
        try {
            FileUtils.writeStringToFile(new File(path), builder.toString());
            logger.debug("写入成功!");
        } catch (IOException e) {
            logger.error(String.format("%s%s", "写入数据异常", e.getMessage()), e);
        }
    }
}
