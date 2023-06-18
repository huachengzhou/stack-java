package blue;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @Description 抓取html
 * @createDate 2018/12/30
 **/
public class GetHtmlDemo {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void test() {
        //设置请求头信息
        WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52);

        try {
            //连接并且获取html响应的内容
            HtmlPage htmlPage = webClient.getPage("https://www.kuaidaili.com/free/");

            //获取id
            HtmlDivision navigationBar = htmlPage.getHtmlElementById("navigationBar");

            //获取元素
            DomNodeList<HtmlElement> domElementDomNodeList = navigationBar.getElementsByTagName("div");

            if (CollectionUtils.isNotEmpty(domElementDomNodeList)) {
                for (HtmlElement htmlElement : domElementDomNodeList) {
                    System.out.println(htmlElement.asXml());
                    System.out.println();
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置代理ip
     */
    @Test
    public void testProxy() {
        //设置请求头信息 (并且设置代理ip)
        WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52,"119.101.112.66",9999);

        //连接并且获取html响应的内容
        try {
            HtmlPage htmlPage = webClient.getPage("https://www.kuaidaili.com/free/");
            System.out.println(htmlPage.asXml());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            webClient.close();
        }
    }

    /**
     * 禁止解析css和js
     */
    @Test
    public void testProxy2() {
        //设置请求头信息 (并且设置代理ip)
        WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52,"119.101.112.66",9999);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        //连接并且获取html响应的内容
        try {
            HtmlPage htmlPage = webClient.getPage("https://www.kuaidaili.com/free/");
            System.out.println(htmlPage.asText());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            webClient.close();
        }
    }

}
