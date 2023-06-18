package com.gold.aspose.example;

import com.aspose.words.Document;
import com.aspose.words.DocumentProperty;
import com.aspose.words.FileFormatInfo;
import com.aspose.words.FileFormatUtil;
import com.gold.aspose.AsposeUtils;
import com.gold.aspose.FileUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.MessageFormat;

/**
 * @Author noatnu
 * @Description
 * @createDate 2019/6/2
 **/
public class AsposeDocumentProperties {


    /*
     * 获取属性
     * @throws Exception
     */
    @Test
    public void test() throws Exception

    {
        String path = FileUtils.getMainDataDir(this.getClass(),"")+"data\\document.doc" ;
        System.out.println(path);

        Document doc = new Document(path);
        System.out.println("============ Built-in Properties ============");
        for (DocumentProperty prop : doc.getBuiltInDocumentProperties())
            System.out.println(MessageFormat.format("{0} : {1}", prop.getName(), prop.getValue()));

        System.out.println("============ Custom Properties ============");
        for (DocumentProperty prop : doc.getCustomDocumentProperties())
            System.out.println(MessageFormat.format("{0} : {1}", prop.getName(), prop.getValue()));

        FileFormatInfo info = FileFormatUtil.detectFileFormat(path);
        System.out.println("The document format is: " + FileFormatUtil.loadFormatToExtension(info.getLoadFormat()));
        System.out.println("Document is encrypted: " + info.isEncrypted());
        System.out.println("Document has a digital signature: " + info.hasDigitalSignature());
    }


    /**
     * 必要的，验证码校验
     */
    @BeforeTest
    public void before(){
        AsposeUtils.checkLicense();
    }
}
