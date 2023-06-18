package testV;



import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zch
 * @Date: 2018/9/30 14:25
 * @Description:
 */
public class Demo1 {
    public static void main(String[] args) {
        String host = "https://ocrapi-house-cert.taobao.com";
        String path = "/ocrservice/houseCert";
        String method = "POST";
        String appcode = "a415256d0b42457791b60904237383c3";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
//        String bodys = "{//图像数据：base64编码，要求base64编码后大小不超过4M，最短边至少15px，最长边最大4096px，支持jpg/png/bmp格式，和url参数只能同时存在一个\"img\":\"\",//图像url地址：图片完整URL，URL长度不超过1024字节，URL对应的图片base64编码后大小不超过4M，最短边至少15px，最长边最大4096px，支持jpg/png/bmp格式，和img参数只能同时存在一个\"url\":\"\"}";
//        String bodys = "{img:'https://github.com/noatnu/web-install/blob/master/zTreejs/src/main/webapp/template/A4.jpg'}";
        String bodys = "{img:'C:\\Users\\13426\\Pictures\\Camera Roll\\房产证.jpg'}";


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
