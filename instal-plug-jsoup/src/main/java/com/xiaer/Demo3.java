package com.xiaer;

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

/**
 * Created by zch on 2019-10-24.
 */
public class Demo3 {

    public static void main(String[] args)throws Exception {
        String url = "https://mp.weixin.qq.com/s?__biz=Mzg4NzAzMzQyOA==&mid=2247486752&idx=3&sn=5b8ae02436a73334196769194abbee05&chksm=cf91d61bf8e65f0d94808de27fc63b191fce6e2d286dc3e9589f728547239969354befaeefde&mpshare=1&scene=1&srcid=&sharer_sharetime=1571891507036&sharer_shareid=2589763411a225f2aa24f075bea1710d&key=911195dd53eca2ded4a4812dd92db51020d7abed788f89d38035755d6862499a5856f7a4c289091e5ae60d482ad8f3fd00f510f605a15e2e4bbcb0255c68195b896f4aa42a26edaa194a2687cb47c580&ascene=1&uin=MjkyOTIxNjQwNw%3D%3D&devicetype=Windows+10&version=62070152&lang=zh_CN&pass_ticket=rh%2Fh3VL8Zpfo%2F41Wh7xGzf%2FuN%2B8P6uQJ4unH8TgJjujm8YoNClbRYhzLnaTRH1KM" ;

        HttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url);
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
        Element element = doc.getElementById("js_content") ;
        System.out.println(element.text());

    }

}
