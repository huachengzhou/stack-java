package com.gold.aspose.example;

import com.aspose.words.*;
import com.gold.aspose.AsposeDataHelp;
import com.gold.aspose.AsposeUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.geom.Rectangle2D;

/**
 * @Author noatnu
 * @Description
 * @createDate 2019/6/4
 **/
public class Demo3 {

    /**
     * 页眉设置
     * @throws Exception
     */
    @Test
    public void testS()throws Exception{
        DocumentBuilder builder = new DocumentBuilder();
        Document doc = builder.getDocument();
        HeaderFooter header = new HeaderFooter(doc, HeaderFooterType.HEADER_PRIMARY);
        doc.getFirstSection().getHeadersFooters().add(header);

        Paragraph para = new Paragraph(doc);
        Run run = new Run(doc,"测试页眉");
        run.getFont().setSize(9.0);
        para.appendChild(run);

        //插入文本框  10.5 5号字体  ，643.8/10.5=61个汉字？  60个汉字
        double height = 643.8;
        Shape shape = new Shape(doc,ShapeType.TEXT_BOX);
        //文本框大小位置
        shape.setWidth(76.95);
        shape.setHeight(height);
        shape.setTop(42.5);
        shape.setLeft(-86.0);
        shape.setBounds(new Rectangle2D.Float(-86.0f, 42.5f, 76.95f, 643.8f));
        shape.setFilled(false);
        shape.setFillColor(new java.awt.Color(255,255,255));
        shape.getFill().setOn(false);
        shape.getFill().setOpacity(1.0);
        shape.getFill().setColor(new java.awt.Color(255,255,255));
        shape.setStroked(false);
        shape.setStrokeColor(new java.awt.Color(0,0,0));
        shape.setFlipOrientation(FlipOrientation.NONE);
        shape.setWrapType(WrapType.SQUARE); //2
        shape.setBehindText(false);
        shape.setRelativeHorizontalPosition(RelativeHorizontalPosition.COLUMN);//2
        shape.setHorizontalAlignment(HorizontalAlignment.NONE);//0
        shape.setRelativeVerticalPosition(RelativeVerticalPosition.PARAGRAPH);//2
        shape.setVerticalAlignment(VerticalAlignment.NONE);//0
        //文本框文字方向  :BOTTOM_TO_TOP 从底网上
        shape.getTextBox().setLayoutFlow(LayoutFlow.BOTTOM_TO_TOP);

        //空行
        Paragraph para0 = new Paragraph(doc);
        para0.getParagraphBreakFont().setSize(9.0);//小五号字体
        para0.getParagraphBreakFont().setName("宋体");
        para0.getParagraphFormat().setAlignment(ParagraphAlignment.JUSTIFY);//两端对齐


        String spaceLine = "                      ";
        Paragraph para1 = new Paragraph(doc);
        para1.getParagraphBreakFont().setSize(10.5);//5号字体
        para1.getParagraphFormat().setFirstLineIndent(105.0);//首行缩进10个字符   105.0=10*10.5  5号字体
        para1.getParagraphFormat().setAlignment(ParagraphAlignment.JUSTIFY);//两端对齐
        Run run1 = new Run(doc,"班级："+spaceLine+"姓名："+spaceLine+"学号：");
        run1.getFont().setName("宋体");
        run1.getFont().setSize(10.5);//5号字体
        para1.appendChild(run1);

        //空行
        Paragraph para2 = new Paragraph(doc);
        para2.getParagraphBreakFont().setSize(9.0);//小五号字体
        para2.getParagraphBreakFont().setName("宋体");
        para2.getParagraphFormat().setAlignment(ParagraphAlignment.JUSTIFY);//两端对齐

        //空行
        Paragraph para3 = new Paragraph(doc);
        para3.getParagraphBreakFont().setSize(9.0);//小五号字体
        para3.getParagraphBreakFont().setName("宋体");
        //Run run3 = new Run(doc,s3);
        //run3.getFont().setName("宋体");
        //run3.getFont().setSize(10.5);//5号字体
        //para3.appendChild(run3);
        para3.getParagraphFormat().setAlignment(ParagraphAlignment.JUSTIFY);//两端对齐

        //装订线
        String endLine = "……………………………………装订线…………………………………………………………………装订线………………………………………";
        Paragraph para4 = new Paragraph(doc);
        para4.getParagraphFormat().setAlignment(ParagraphAlignment.JUSTIFY);//两端对齐
        Run run4 = new Run(doc,endLine);
        run4.getFont().setName("宋体");
        run4.getFont().setSize(10.5);//5号字体
        para4.appendChild(run4);

        shape.appendChild(para0);
        shape.appendChild(para1);
        shape.appendChild(para2);
        shape.appendChild(para3);
        shape.appendChild(para4);

        //画线条，一个线条是一个shape，线条在文本框文字下面
        double lineHeight = 109.2;
        double lineLeft = -45.0;
        Shape shapeLine1 = new Shape(doc,ShapeType.LINE);
        shapeLine1.getFont().setSize(9.0);//小五
        shapeLine1.setWidth(0.0);
        shapeLine1.setHeight(lineHeight);
        shapeLine1.setTop(143.9);
        shapeLine1.setLeft(lineLeft);

        Shape shapeLine2 = new Shape(doc,ShapeType.LINE);
        shapeLine2.getFont().setSize(9.0);//小五
        shapeLine2.setWidth(0.0);
        shapeLine2.setHeight(lineHeight);
        shapeLine2.setTop(292.1);
        shapeLine2.setLeft(lineLeft);

        Shape shapeLine3 = new Shape(doc,ShapeType.LINE);
        shapeLine3.getFont().setSize(9.0);//小五
        shapeLine3.setWidth(0.0);
        shapeLine3.setHeight(lineHeight);
        shapeLine3.setTop(440.3);
        shapeLine3.setLeft(lineLeft);

        para.appendChild(shape);
        para.appendChild(shapeLine1);
        para.appendChild(shapeLine2);
        para.appendChild(shapeLine3);

        // Add a paragraph with text to the footer.
        header.appendChild(para);


        //创建页脚 页码

        HeaderFooter footer = new HeaderFooter(doc, HeaderFooterType.FOOTER_PRIMARY);
        doc.getFirstSection().getHeadersFooters().add(footer);

        //页脚段落
        Paragraph footerpara = new Paragraph(doc);
        footerpara.getParagraphFormat().setAlignment(ParagraphAlignment.CENTER);

        Run footerparaRun = new Run(doc,"共 ");
        footerparaRun.getFont().setName("宋体");
        footerparaRun.getFont().setSize(9.0);//小5号字体
        footerpara.appendChild(footerparaRun);

        footerpara.appendField(FieldType.FIELD_NUM_PAGES,true);//总页码

        footerparaRun = new Run(doc," 页，第 ");
        footerparaRun.getFont().setName("宋体");
        footerparaRun.getFont().setSize(9.0);//小5号字体
        footerpara.appendChild(footerparaRun);

        footerpara.appendField(FieldType.FIELD_PAGE,true);//当前页码

        footerparaRun = new Run(doc," 页");
        footerparaRun.getFont().setName("宋体");
        footerparaRun.getFont().setSize(9.0);//小5号字体
        footerpara.appendChild(footerparaRun);

        footer.appendChild(footerpara);
        doc.save(AsposeDataHelp.getPath(), SaveFormat.DOCX);
    }

    @Test
    public void testH()throws Exception{
        DocumentBuilder builder = new DocumentBuilder();
        Document doc = builder.getDocument();
        //将光标移到目录书签
        builder.moveToBookmark("TOC");
        builder.insertBreak(BreakType.PAGE_BREAK);

        //设置目录的格式
        //“目录”两个字居中显示、加粗、搜宋体
        builder.getCurrentParagraph().getParagraphFormat().setAlignment(ParagraphAlignment.CENTER);
        builder.setBold(true);
        builder.getFont().setName("微软雅黑");
        builder.writeln("目录");
        //清清除所有样式设置
        builder.getParagraphFormat().clearFormatting();
        //目录居左
        builder.getParagraphFormat().setAlignment(ParagraphAlignment.LEFT);
        //插入目录，这是固定的
        builder.insertTableOfContents("\\o \"1-3\" \\h \\z \\u");

        // Start the actual document content on the second page.
        builder.insertBreak(BreakType.SECTION_BREAK_NEW_PAGE);

        // Build a document with complex structure by applying different heading styles thus  creating TOC entries.

        builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_1);
        builder.writeln("Heading 1");

        builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_2);
        builder.writeln("Heading 1.1");
        builder.writeln("Heading 1.2");

        builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_1);
        builder.writeln("Heading 2");
        builder.writeln("Heading 3");
        builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_2);
        builder.writeln("Heading 3.1");

        builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_3);
        builder.writeln("Heading 3.1.1");
        builder.writeln("Heading 3.1.2");
        builder.writeln("Heading 3.1.3");

        builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_2);
        builder.writeln("Heading 3.2");
        builder.writeln("Heading 3.3");

        builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.BODY_TEXT);

        // Call the method below to update the TOC.
        doc.updateFields();
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
