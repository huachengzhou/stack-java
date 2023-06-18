package blue;

import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.testng.annotations.Test;
import tool.utils.word.aspose.AsposeUtils;

import java.io.IOException;

public class Test2 {

    @Test
    public void test4() {
        String path = "D:\\data\\";
        String url = "https://blog.csdn.net/gertyy/article/details/53637951";
        WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52);

        webClient.getOptions().setThrowExceptionOnScriptError(false);//当JS执行出错的时候是否抛出异常
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);//当HTTP的状态非200时是否抛出异常
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setCssEnabled(false);//是否启用CSS
        webClient.getOptions().setJavaScriptEnabled(true); //很重要，启用JS
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());//很重要，设置支持AJAX

        webClient.getOptions().setTimeout(2000);//设置“浏览器”的请求超时时间
        webClient.setJavaScriptTimeout(2000);//设置JS执行的超时时间

        try {
            //连接并且获取html响应的内容
            HtmlPage htmlPage = webClient.getPage(url);

            //获取id
            HtmlDivision navigationBar = htmlPage.getHtmlElementById("content_views");

            String asXml = navigationBar.asXml();
            String dir = path.toString() + "canvas_api" + ".doc";
            Document doc2 = new Document();
            DocumentBuilder builder = new DocumentBuilder(doc2);
            builder.insertHtml(asXml);
            AsposeUtils.checkLicense();
            AsposeUtils.saveWord(dir, doc2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
