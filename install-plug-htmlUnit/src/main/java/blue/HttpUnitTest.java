package blue;

import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.apache.commons.collections.CollectionUtils;
import org.testng.annotations.Test;
import tool.utils.word.aspose.AsposeUtils;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * @Description web 方式获取连接资源
 * @createDate 2018/12/30
 **/
public class HttpUnitTest {


    @Test
    public void test2()throws Exception{
        String path = "D:\\huan\\" ;
        String url = "https://mp.weixin.qq.com/s?__biz=Mzg4NzAzMzQyOA==&mid=2247486752&idx=3&sn=5b8ae02436a73334196769194abbee05&chksm=cf91d61bf8e65f0d94808de27fc63b191fce6e2d286dc3e9589f728547239969354befaeefde&mpshare=1&scene=1&srcid=&sharer_sharetime=1571891507036&sharer_shareid=2589763411a225f2aa24f075bea1710d&key=911195dd53eca2ded4a4812dd92db51020d7abed788f89d38035755d6862499a5856f7a4c289091e5ae60d482ad8f3fd00f510f605a15e2e4bbcb0255c68195b896f4aa42a26edaa194a2687cb47c580&ascene=1&uin=MjkyOTIxNjQwNw%3D%3D&devicetype=Windows+10&version=62070152&lang=zh_CN&pass_ticket=rh%2Fh3VL8Zpfo%2F41Wh7xGzf%2FuN%2B8P6uQJ4unH8TgJjujm8YoNClbRYhzLnaTRH1KM" ;
        WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52);
        try {
            //连接并且获取html响应的内容
            HtmlPage htmlPage = webClient.getPage(url);

            //获取id
            HtmlDivision navigationBar = htmlPage.getHtmlElementById("js_content");

            //获取元素
            DomNodeList<HtmlElement> domElementDomNodeList = navigationBar.getElementsByTagName("p");

            if (CollectionUtils.isNotEmpty(domElementDomNodeList)) {
                for (HtmlElement htmlElement : domElementDomNodeList) {
                    DomNodeList<HtmlElement> elementDomNodeList =htmlElement.getElementsByTagName("a");

                    if (CollectionUtils.isNotEmpty(elementDomNodeList)){
                        for (HtmlElement element : elementDomNodeList){
                            String href = element.getAttribute("href");
                            System.out.println(href);

                            try {
                                WebClient webClient2 = new WebClient(BrowserVersion.FIREFOX_52);
                                HtmlPage htmlPage2 = webClient2.getPage(href);
//                            System.out.println(htmlPage2.asText());
                                String dir = path.toString()+element.asText()+".doc" ;
                                Document doc2 = new Document();
                                DocumentBuilder builder = new DocumentBuilder(doc2);
                                builder.insertHtml(htmlPage2.asXml());
                                AsposeUtils.saveWord(dir,doc2);
                            } catch (Exception e) {

                            }
                        }
                    }
                }
            }


        } catch (IOException e) {
        }

        webClient.close();
    }



    @Test
    public void test1()throws IOException {
        WebClient webClient = new WebClient() ;
        HtmlPage htmlPage = webClient.getPage("http://www.89ip.cn/");//解析的网页

        //网页html
        System.out.println(htmlPage.asXml());
        //网页文本
        System.out.println(htmlPage.asText());

        webClient.close();
    }

    /**
     * 模拟点击
     */
    @Test
    public void click(){
        WebClient webClient=new WebClient(BrowserVersion.FIREFOX_52); // 实例化Web客户端
        try {
            HtmlPage page=webClient.getPage("http://blog.java1234.com/index.html"); // 解析获取页面
            HtmlForm form=page.getFormByName("myform"); // 获取搜索Form
            HtmlTextInput textField=form.getInputByName("q"); // 获取查询文本框
            HtmlSubmitInput button=form.getInputByName("submitButton"); // 获取提交按钮
            textField.setValueAttribute("java"); // 文本框“填入”数据
            HtmlPage resultPage=button.click(); // 模拟点击 获取查询结果页面
            System.out.println(resultPage.asXml());
        } catch (FailingHttpStatusCodeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            webClient.close(); // 关闭客户端，释放内存
        }
    }

    @Test
    public void getBaiDu()throws Exception{
        WebClient webClient=new WebClient(BrowserVersion.FIREFOX_52); // 实例化Web客户端
        try {
            HtmlPage page=webClient.getPage("https://pan.baidu.com/share/home?uk=305605848#category/type=0"); // 解析获取页面
            Thread.sleep(10000); // 休息10秒 等待htmlunit执行Js
            System.out.println("网页html:"+page.asXml());
        } catch (FailingHttpStatusCodeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            webClient.close(); // 关闭客户端，释放内存
        }
    }

}
