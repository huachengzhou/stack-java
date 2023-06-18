package hello;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/12/29
 **/
public class HelloWorld {

    @Test
    public void testClient() {
        // 1:创建httpClient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //2:创建httpGet实例
        String url = "https://www.csdn.net/";//http://www.tuicool.com/
        HttpGet httpGet = new HttpGet(url);

        CloseableHttpResponse httpResponse = null;

        //3:用httpClient执行get请求获取相应的实体
        try {
            httpResponse = httpClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //4：获取返回实体
        HttpEntity httpEntity = httpResponse.getEntity();

        //5:获取网页内容
        try {
            if (httpEntity != null) {
                String s = EntityUtils.toString(httpEntity, "utf-8");
                if (StringUtils.isNotEmpty(s)) {
                    System.out.println(s);
                    httpClient.close();
                    httpResponse.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
