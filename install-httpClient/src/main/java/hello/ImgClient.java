package hello;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @Description 图片
 * @createDate 2018/12/30
 **/
public class ImgClient {

    /**
     * chrome 头 并且用post抓取 图片
     */
    @Test
    public void testClient() {
        HttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("https://www.baidu.com/img/qdong_cb8a6b9183d8f4976011612f47bcb621.gif");
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36");
        HttpResponse httpResponse = null;

        try {
            httpResponse = httpClient.execute(httpPost);
            if (httpResponse != null) {
                HttpEntity httpEntity = httpResponse.getEntity();
                InputStream inputStream = null;
                inputStream = httpEntity.getContent();
                FileUtils.copyInputStreamToFile(inputStream,new File("E:\\doc\\"+ UUID.randomUUID().toString().substring(1,5)+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
