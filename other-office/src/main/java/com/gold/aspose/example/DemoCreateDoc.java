package com.gold.aspose.example;

import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;
import com.aspose.words.SaveFormat;
import com.gold.aspose.AsposeDataHelp;
import com.gold.aspose.AsposeUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @Author noatnu
 * @Description
 * @createDate 2019/6/2
 **/
public class DemoCreateDoc {

    /**
     * aspose 方式创建word
     * @throws Exception
     */
    @Test
    public void testA()throws Exception{
        Document doc = new Document();
        // DocumentBuilder provides members to easily add content to a document.

        DocumentBuilder builder = new DocumentBuilder(doc);
        // Write a new paragraph in the document with some text as "Sample Content..."

        builder.setBold(true);

        builder.writeln("Aspose Sample Content for Word file.");

        // Save the document in DOCX format. The format to save as is inferred from the extension of the file name.
        // Aspose.Words supports saving any document in many more formats.
        doc.save(AsposeDataHelp.getPath(), SaveFormat.DOCX);
    }

    /**
     * 必要的，验证码校验
     */
    @BeforeTest
    public void before(){
        AsposeUtils.checkLicense();
    }

}
