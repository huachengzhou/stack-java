package com.gold.aspose.example;

import com.aspose.words.*;
import com.gold.aspose.AsposeDataHelp;
import com.gold.aspose.AsposeUtils;
import com.google.common.collect.Lists;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author: zch
 * @date: 2019/6/3 09:30
 * @description:
 */
public class Demo2 {

    @Test
    public void test1()throws Exception{
        Document doc = new Document();
        DocumentBuilder builder = new DocumentBuilder(doc);
        StringBuilder stringBuilder = new StringBuilder(8) ;
        for (int i = 0; i < 4; i++) {
            stringBuilder.delete(0,stringBuilder.toString().length()) ;
            String value = RandomStringUtils.randomAlphabetic(12);

            builder.insertBreak(BreakType.PAGE_BREAK);
            stringBuilder.append("\"").append(value).append("\"") ;
//            builder.insertField("PAGE") ;
//            builder.insertField("MERGEFIELD  \\* MERGEFORMAT");
            builder.insertField("MERGEFIELD");
            builder.writeln(value);
            System.out.println(value);
        }
        doc.save(AsposeDataHelp.getPath(), SaveFormat.DOCX);
    }

    @Test
    public void test2()throws Exception{
        List<String> stringList = Lists.newArrayList();
        for (int i = 0; i < 6; i++) {
            stringList.add(RandomStringUtils.randomAlphabetic(13)) ;
        }
        AsposeUtils.insertBreakValue(AsposeDataHelp.getPath(),null,null,stringList);
    }

    @Test
    public void testG() throws Exception {
        Document doc = new Document();
        DocumentBuilder builder = new DocumentBuilder(doc);
        builder.insertBreak(BreakType.PAGE_BREAK);
        /*Move DocumentBuilder cursor into the primary footer. 将DocumentBuilder光标移到主页脚中 */
        builder.moveToHeaderFooter(HeaderFooterType.FOOTER_PRIMARY);

        String value = RandomStringUtils.randomAlphabetic(12);
        System.out.println(value);
        Field field = builder.insertField(value);
//        builder.moveTo(field.getSeparator());
        builder.insertField("PAGE");
        builder.write(" <> ");
        doc.save(AsposeDataHelp.getPath(), SaveFormat.DOCX);
    }

    @Test
    public void test3() throws Exception {
        Document doc = new Document();
        DocumentBuilder builder = new DocumentBuilder(doc);

        Section currentSection = builder.getCurrentSection();
        PageSetup pageSetup = currentSection.getPageSetup();

        // Specify if we want headers/footers of the first page to be different from other pages.
        // You can also use PageSetup.OddAndEvenPagesHeaderFooter property to specify
        // different headers/footers for odd and even pages.
        pageSetup.setDifferentFirstPageHeaderFooter(true);

        // --- Create header for the first page. ---
        pageSetup.setHeaderDistance(20);
        builder.moveToHeaderFooter(HeaderFooterType.FOOTER_FIRST);
        builder.getParagraphFormat().setAlignment(ParagraphAlignment.CENTER);

        // Set font properties for header text.
        builder.getFont().setName("Arial");
        builder.getFont().setBold(true);
        builder.getFont().setSize(14);

        // Specify header title for the first page.
        builder.write("(C) 2001 Aspose Pty Ltd. All rights reserved.");
        doc.save(AsposeDataHelp.getPath(), SaveFormat.DOCX);
    }

    @Test
    public void test4() throws Exception {
        Document doc = new Document();
        DocumentBuilder builder = new DocumentBuilder(doc);

        Section currentSection = builder.getCurrentSection();
        PageSetup pageSetup = currentSection.getPageSetup();

        // Specify if we want headers/footers of the first page to be different from other pages.
        // You can also use PageSetup.OddAndEvenPagesHeaderFooter property to specify
        // different headers/footers for odd and even pages.
        pageSetup.setDifferentFirstPageHeaderFooter(true);

        // --- Create header for the first page. ---
        pageSetup.setHeaderDistance(20);
        builder.moveToHeaderFooter(HeaderFooterType.HEADER_FIRST);
        builder.getParagraphFormat().setAlignment(ParagraphAlignment.CENTER);

        // Set font properties for header text.
        builder.getFont().setName("Arial");
        builder.getFont().setBold(true);
        builder.getFont().setSize(14);
        // Specify header title for the first page.
        builder.write("Aspose.Words Header/Footer Creation Primer - Title Page.");
        doc.save(AsposeDataHelp.getPath(), SaveFormat.DOCX);
    }

    /**
     * 必要的，验证码校验
     */
    @BeforeTest
    public void before() {
        AsposeUtils.checkLicense();
    }

}
