package hello;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @Description 代理ip
 * @createDate 2018/12/30
 **/
public class HttpProxyClient {

    /**
     * 非关闭连接
     */
    @Test
    public void testProxy() {
        HttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("http://www.runoob.com/");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36");
        //设置代理IP (来源:https://www.kuaidaili.com/free/)
        HttpHost httpHost = new HttpHost("123.206.6.218", 8888);
        RequestConfig config = RequestConfig.custom().setProxy(httpHost).build();
        httpGet.setConfig(config);
        HttpResponse httpResponse = null;

        try {
            httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();

            System.out.println(EntityUtils.toString(httpEntity, "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置超时时间和读取时间
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault(); // 创建httpClient实例
        HttpGet httpGet = new HttpGet("http://central.maven.org/maven2/"); // 创建httpget实例
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(10000) // 设置连接超时时间 10秒钟
                .setSocketTimeout(20000) // 设置读取超时时间10秒钟
                .build();
        httpGet.setConfig(config);
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
        CloseableHttpResponse response = httpClient.execute(httpGet); // 执行http get请求
        HttpEntity entity = response.getEntity(); // 获取返回实体
        System.out.println("网页内容：" + EntityUtils.toString(entity, "utf-8")); // 获取网页内容
        response.close(); // response关闭
        httpClient.close(); // httpClient关闭
    }

    /**
     * 可关闭连接
     *
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault(); // 创建httpClient实例
        HttpGet httpGet = new HttpGet("http://www.tuicool.com/"); // 创建httpget实例
        HttpHost proxy = new HttpHost("123.206.6.218", 8888);
        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
        httpGet.setConfig(config);
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
        CloseableHttpResponse response = httpClient.execute(httpGet); // 执行http get请求
        HttpEntity entity = response.getEntity(); // 获取返回实体
        System.out.println("网页内容：" + EntityUtils.toString(entity, "utf-8")); // 获取网页内容
        response.close(); // response关闭
        httpClient.close(); // httpClient关闭
    }

}
