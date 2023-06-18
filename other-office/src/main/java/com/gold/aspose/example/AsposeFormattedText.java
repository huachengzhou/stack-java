package com.gold.aspose.example;

import com.aspose.words.*;
import com.aspose.words.Font;
import com.gold.aspose.AsposeDataHelp;
import com.gold.aspose.AsposeUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;

/**
 * @Author noatnu
 * @Description
 * @createDate 2019/6/2
 **/
public class AsposeFormattedText {


    /**
     * 格式化
     * @throws Exception
     */
    @Test
    public void testA()throws Exception{
        Document doc = new Document();
        DocumentBuilder builder = new DocumentBuilder(doc);

        // Set paragraph formatting properties
        ParagraphFormat paragraphFormat = builder.getParagraphFormat();
        paragraphFormat.setAlignment(ParagraphAlignment.CENTER);
        paragraphFormat.setLeftIndent(50);
        paragraphFormat.setRightIndent(50);
        paragraphFormat.setSpaceAfter(25);

        // Output text
        builder.writeln("I'm a very nice formatted paragraph. I'm intended to demonstrate how the left and right indents affect word wrapping.");

        // Set font formatting properties
        Font font = builder.getFont();
        font.setBold(true);
        font.setColor(Color.BLUE);
        font.setItalic(true);
        font.setName("Arial");
        font.setSize(24);
        font.setSpacing(5);
        font.setUnderline(Underline.DOUBLE);
        // Output formatted text
        builder.writeln("I'm a very nice formatted string.");
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
