package com.gold.aspose.myself;

import com.aspose.words.*;
import com.gold.aspose.AsposeDataHelp;
import com.gold.aspose.AsposeUtils;
import com.gold.aspose.DateUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.Date;
import java.util.UUID;

/**
 * @Author noatnu
 * @Description
 * @createDate 2019/6/19
 **/
public class DemoDocExample2 {


    /**
     * 分页和页眉一起使用
     *
     * @throws Exception
     */
    @Test
    public void testA() throws Exception {
        Document doc = new Document();
        DocumentBuilder documentBuilder = new DocumentBuilder(doc);
        documentBuilder.getFont().setName("微软雅黑");
        documentBuilder.getFont().setColor(Color.red);
        documentBuilder.getFont().setSize(14);
        //获取段落格式化工具
        ParagraphFormat paragraphFormat = documentBuilder.getParagraphFormat();//可以直接从documentBuilder获取段落的格式工具
        //设置对齐
        paragraphFormat.setAlignment(ParagraphAlignment.JUSTIFY);
        //设置左缩进
        paragraphFormat.setLeftIndent(0);
        //设置行间距
        paragraphFormat.setLineSpacing(12);
        //设置右缩进
        paragraphFormat.setRightIndent(0);
        //设置后空间
        paragraphFormat.setSpaceAfter(25);
        //设置首行缩进
        paragraphFormat.setFirstLineIndent(25);

        {
            //目前来看头页眉只能设置一个,然后每页复用
            HeaderFooter headerFooter = new HeaderFooter(doc, HeaderFooterType.HEADER_PRIMARY);
            doc.getFirstSection().getHeadersFooters().add(headerFooter);
            Paragraph paragraph = headerFooter.appendParagraph(DateUtils.format(new Date(), DateUtils.DATE_PATTERN));
            paragraph.getParagraphFormat().setAlignment(ParagraphAlignment.CENTER);
            if (paragraph.getRuns().toArray().length >= 1) {
                paragraph.getRuns().get(0).getFont().setBold(true);
                paragraph.getRuns().get(0).getFont().setColor(Color.red);
            }
        }
        final int page = 4;

        for (int i = 0; i < page; i++) {
            StringBuffer stringBuffer = new StringBuffer(8);
            for (int j = 0; j < 25; j++) {
                stringBuffer.append(RandomStringUtils.random(23));
            }
            documentBuilder.write(stringBuffer.toString());
            stringBuffer.delete(0, stringBuffer.length());
            if (i != page - 1) {
                documentBuilder.insertBreak(BreakType.PAGE_BREAK);
            }
        }

        {
            //尾页眉
            HeaderFooter headerFooter = new HeaderFooter(doc, HeaderFooterType.FOOTER_PRIMARY);
            doc.getFirstSection().getHeadersFooters().add(headerFooter);
            Paragraph paragraph = headerFooter.appendParagraph("中华人民共和国");
            paragraph.getParagraphFormat().setAlignment(ParagraphAlignment.CENTER);
        }

        doc.save(AsposeDataHelp.getPath(), SaveFormat.DOCX);
    }

    @Test
    public void testB() throws Exception {
        Document doc = new Document();
        DocumentBuilder documentBuilder = new DocumentBuilder(doc);
        documentBuilder.getFont().setName("宋体");
        documentBuilder.getFont().setColor(Color.red);
        documentBuilder.getFont().setSize(14);


        //创建页脚 页码
        HeaderFooter footer = new HeaderFooter(doc, HeaderFooterType.FOOTER_PRIMARY);
        doc.getFirstSection().getHeadersFooters().add(footer);

        Paragraph paragraph = new Paragraph(doc);
        paragraph.getParagraphFormat().setAlignment(ParagraphAlignment.CENTER);
        {
            Run run = new Run(doc, "共 ");
            run.getFont().setName("宋体");
            run.getFont().setSize(9);
            paragraph.appendChild(run);
            paragraph.appendField(FieldType.FIELD_NUM_PAGES, true);//总页码
        }

        {
            Run run = new Run(doc, " 页,第 ");
            run.getFont().setName("宋体");
            run.getFont().setSize(9);
            paragraph.appendChild(run);
            paragraph.appendField(FieldType.FIELD_PAGE, true);//当前页码
        }

        {
            Run run = new Run(doc, "页");
            run.getFont().setName("宋体");
            run.getFont().setSize(9);
            paragraph.appendChild(run);
        }
        //最后把段落插入
        footer.appendChild(paragraph);

        final int page = 4;

        for (int i = 0; i < page; i++) {

            StringBuffer stringBuffer = new StringBuffer(8);
            for (int j = 0; j < 23; j++) {
                stringBuffer.append(RandomStringUtils.random(33));
            }
            documentBuilder.write(stringBuffer.toString());
            stringBuffer.delete(0, stringBuffer.length());
            if (i != page - 1) {
                documentBuilder.insertBreak(BreakType.PAGE_BREAK);
            }
        }


        doc.save(AsposeDataHelp.getPath(), SaveFormat.DOCX);
    }


    @Test
    public void testD() throws Exception {
        Document doc = new Document();
        DocumentBuilder documentBuilder = new DocumentBuilder(doc);
        documentBuilder.getFont().setName("宋体");
        documentBuilder.getFont().setColor(Color.red);
        documentBuilder.getFont().setSize(14);

        {
            //头页眉
            HeaderFooter headerFooter = new HeaderFooter(doc, HeaderFooterType.HEADER_PRIMARY);
            doc.getFirstSection().getHeadersFooters().add(headerFooter);
            Paragraph paragraph = headerFooter.appendParagraph(DateUtils.format(new Date(), DateUtils.DATE_PATTERN));
            paragraph.getParagraphFormat().setAlignment(ParagraphAlignment.CENTER);
            if (paragraph.getRuns().toArray().length >= 1) {
                paragraph.getRuns().get(0).getFont().setBold(true);
                paragraph.getRuns().get(0).getFont().setColor(Color.red);
            }
        }

        final int page = 4;

        for (int i = 0; i < page; i++) {

            StringBuffer stringBuffer = new StringBuffer(8);
            for (int j = 0; j < 23; j++) {
                stringBuffer.append(RandomStringUtils.random(33));
            }
            documentBuilder.write(stringBuffer.toString());
            stringBuffer.delete(0, stringBuffer.length());
            if (i != page - 1) {
                documentBuilder.insertBreak(BreakType.PAGE_BREAK);
            }
        }


        //这里实际上是 尾页眉 和 页码设置在一起了
        {
            //创建尾页眉
            HeaderFooter headerFooter = new HeaderFooter(doc, HeaderFooterType.FOOTER_PRIMARY);
            doc.getFirstSection().getHeadersFooters().add(headerFooter);
            Paragraph paragraph2 = headerFooter.appendParagraph("中华人民共和国");
            paragraph2.getParagraphFormat().setAlignment(ParagraphAlignment.CENTER);


            //创建页脚 页码
            Paragraph paragraph = new Paragraph(doc);
            paragraph.getParagraphFormat().setAlignment(ParagraphAlignment.CENTER);
            {
                Run run = new Run(doc, "共 ");
                run.getFont().setName("宋体");
                run.getFont().setSize(9);
                paragraph.appendChild(run);
                paragraph.appendField(FieldType.FIELD_NUM_PAGES, true);//总页码
            }

            {
                Run run = new Run(doc, " 页,第 ");
                run.getFont().setName("宋体");
                run.getFont().setSize(9);
                paragraph.appendChild(run);
                paragraph.appendField(FieldType.FIELD_PAGE, true);//当前页码
            }

            {
                Run run = new Run(doc, "页");
                run.getFont().setName("宋体");
                run.getFont().setSize(9);
                paragraph.appendChild(run);
            }
            //最后把段落插入
            headerFooter.appendChild(paragraph);
        }

        doc.save(AsposeDataHelp.getPath(), SaveFormat.DOCX);
    }

    /**
     * 从此方法可以看到页眉无法每页都插入 只能从域中想办法
     * @throws Exception
     */
    @Test
    public void testE() throws Exception {
        Document doc = new Document();
        DocumentBuilder documentBuilder = new DocumentBuilder(doc);
        documentBuilder.getFont().setName("宋体");
        documentBuilder.getFont().setColor(Color.red);
        documentBuilder.getFont().setSize(14);

        //头页眉
        HeaderFooter headerFooter = new HeaderFooter(doc, HeaderFooterType.HEADER_PRIMARY);
        doc.getFirstSection().getHeadersFooters().add(headerFooter);
        Paragraph paragraph = headerFooter.appendParagraph(DateUtils.format(new Date(), DateUtils.DATE_PATTERN));
        {
            Run run = new Run(doc, "页数");
            run.getFont().setName("宋体");
            run.getFont().setSize(14);
            run.getFont().setColor(Color.blue);
            paragraph.appendChild(run);
            paragraph.appendField(FieldType.FIELD_PAGE, true);//当前页码
        }
        paragraph.getParagraphFormat().setAlignment(ParagraphAlignment.CENTER);
        if (paragraph.getRuns().toArray().length >= 1) {
            paragraph.getRuns().get(0).getFont().setBold(true);
            paragraph.getRuns().get(0).getFont().setColor(Color.red);
            paragraph.getRuns().get(0).getFont().setSize(14);
        }
        final int page = 4;
        for (int i = 0; i < page; i++) {
            StringBuffer stringBuffer = new StringBuffer(8);
            for (int j = 0; j < 23; j++) {
                stringBuffer.append(RandomStringUtils.random(33));
            }
            documentBuilder.write(stringBuffer.toString());
            stringBuffer.delete(0, stringBuffer.length());
            if (i != page - 1) {
                documentBuilder.insertBreak(BreakType.SECTION_BREAK_NEW_PAGE);
            }
        }
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
