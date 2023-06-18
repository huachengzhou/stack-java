package com.gold.aspose.example;

import com.aspose.words.ControlChar;
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
public class AsposeUseControlCharacters {


    /**
     * 使用控制字符
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        // Load the document.
        Document doc = new Document();

        // DocumentBuilder provides members to easily add content to a document.
        DocumentBuilder builder = new DocumentBuilder(doc);
        // Write a new paragraph in the document with some text as "Sample Content..."
        builder.setBold(true);
        builder.writeln("Aspose Sample Content for Word file.\r More Sample");

        String text = doc.getText();
        System.out.println("Doc Text: " + text);

        //Replace "\r" control character with "\r\n"
        text = text.replace(ControlChar.CR, ControlChar.CR_LF);
        System.out.println("Doc Text: " + text);

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
