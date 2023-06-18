package close;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.Test;

/**
 * @Description
 * @createDate 2018/12/31
 **/
public class Example {

    @Test
    public void testA(){


        CloseableHttpClient httpClient = HttpClients.createDefault();


    }

}
