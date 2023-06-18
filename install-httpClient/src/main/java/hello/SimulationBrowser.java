package hello;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @Description 模拟浏览器请求
 * @createDate 2018/12/29
 **/
public class SimulationBrowser {

    /**
     * 模拟火狐浏览器
     */
    @Test
    public void firefox() {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String url = "http://www.tuicool.com/";
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
        HttpResponse httpResponse = null;

        try {
            httpResponse = httpClient.execute(httpGet);

            HttpEntity httpEntity = httpResponse.getEntity();

            String string = EntityUtils.toString(httpEntity, "utf-8");

            System.out.println(string);

            System.out.println(httpEntity.getContent());

            System.out.println(httpEntity.getContentType());

            System.out.println(httpEntity.getContentEncoding());

            System.out.println(httpEntity.getContentLength());
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ：获取响应内容类型 Content-Type
     * @throws Exception
     */
    @Test
    public void getContent_Type() throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault(); // 创建httpClient实例

        HttpGet httpGet = new HttpGet("http://central.maven.org/maven2/HTTPClient/HTTPClient/0.3-3/HTTPClient-0.3-3.jar"); // 创建httpGet实例
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");

        CloseableHttpResponse response = httpClient.execute(httpGet); // 执行http get请求

        HttpEntity entity = response.getEntity(); // 获取返回实体

        System.out.println("Content-Type:" + entity.getContentType().getValue());

        response.close(); // response关闭
        httpClient.close(); // httpClient关闭
    }

    /**
     * 获取状态码
     * @throws Exception
     */
    @Test
    public void getStatus()throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault(); // 创建httpClient实例

        HttpGet httpGet = new HttpGet("http://www.bejson.com/"); // 创建httpGet实例
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");

        CloseableHttpResponse response = httpClient.execute(httpGet); // 执行http get请求
        //获取状态实体类
        System.out.println(response.getStatusLine());
        //获取状态码
        System.out.println(response.getStatusLine().getStatusCode());
    }

}
