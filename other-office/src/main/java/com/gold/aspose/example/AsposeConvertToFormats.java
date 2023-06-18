package com.gold.aspose.example;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;
import com.gold.aspose.AsposeDataHelp;
import com.gold.aspose.AsposeUtils;
import com.gold.aspose.FileUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @Author noatnu
 * @Description
 * @createDate 2019/6/2
 **/
public class AsposeConvertToFormats {

    /**
     * Aspose 转换为Html 或者pdf
     * @throws Exception
     */
    @Test
    public void testV()throws Exception{
        String path = FileUtils.getMainDataDir(this.getClass(),"")+"data\\document.doc" ;
        System.out.println(path);

        Document doc = new Document(path);

        doc.save(AsposeDataHelp.getPath("html"), SaveFormat.HTML); //Save the document in HTML format.
        doc.save(AsposeDataHelp.getPath("pdf"),SaveFormat.PDF); //Save the document in PDF format.
        doc.save(AsposeDataHelp.getPath("text"),SaveFormat.TEXT); //Save the document in TXT format.
        doc.save(AsposeDataHelp.getPath("jpg"), SaveFormat.JPEG); //Save the document in JPEG format.

    }

    /**
     * 必要的，验证码校验
     */
    @BeforeTest
    public void before(){
        AsposeUtils.checkLicense();
    }

}
