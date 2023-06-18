package com.gold.aspose.myself;

import com.aspose.words.*;
import com.gold.aspose.AsposeDataHelp;
import com.gold.aspose.AsposeUtils;
import com.gold.aspose.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;

/**
 * @Author noatnu
 * @Description
 * @createDate 2019/6/8
 **/
public class DemoDocExample {

    /**
     * 创建一个文档并且写入数据
     *
     * @throws Exception
     */
    @Test
    public void testA() throws Exception {
        Document doc = new Document();
        DocumentBuilder documentBuilder = new DocumentBuilder(doc);
        documentBuilder.writeln(RandomStringUtils.randomNumeric(22));
        doc.save(AsposeDataHelp.getPath(), SaveFormat.DOCX);
    }

    /**
     * 创建一个文档并且按照我们自定义设计的字体样式写入的数据
     *
     * @throws Exception
     */
    @Test
    public void testB() throws Exception {
        Document doc = new Document();
        DocumentBuilder documentBuilder = new DocumentBuilder(doc);
        documentBuilder.getFont().setName("宋体");
        //设置下划线 最好不好超过3
        documentBuilder.getFont().setUnderline(1);
        documentBuilder.getFont().setColor(Color.blue);
        documentBuilder.getFont().setSize(14);
        //是否斜体
        documentBuilder.getFont().setItalic(true);
        //是否加粗
        documentBuilder.getFont().setBold(true);
        //设置间距
        documentBuilder.getFont().setSpacing(4);
        //设置下划线颜色
//        documentBuilder.getFont().setUnderlineColor(Color.ORANGE);
        //设置字距
        documentBuilder.getFont().setKerning(1);
        //设置刻度
//        documentBuilder.getFont().setScaling(1);
        //设置位置
        documentBuilder.getFont().setPosition(4);
        for (int i = 0; i < 4; i++) {
            documentBuilder.writeln(RandomStringUtils.randomAlphabetic(22));
        }
        doc.save(AsposeDataHelp.getPath(), SaveFormat.DOCX);
    }

    /**
     * 添加段落  注意段落样式会覆盖,重复设置的情况
     *
     * @throws Exception
     */
    @Test
    public void testC() throws Exception {
        Document doc = new Document();
        DocumentBuilder documentBuilder = new DocumentBuilder(doc);
        documentBuilder.getFont().setName("宋体");
        documentBuilder.getFont().setColor(Color.red);
        documentBuilder.getFont().setSize(14);

        {
            //插入一个段落
            Paragraph paragraph = documentBuilder.insertParagraph();
            //获取段落格式化工具
            ParagraphFormat paragraphFormat = paragraph.getParagraphFormat();
            //设置对齐
            paragraphFormat.setAlignment(ParagraphAlignment.CENTER);
            //设置左缩进
            paragraphFormat.setLeftIndent(0);
            //设置右缩进
            paragraphFormat.setRightIndent(50);
            //设置后空间
            paragraphFormat.setSpaceAfter(25);
            //设置首行缩进
            paragraphFormat.setFirstLineIndent(8);
            documentBuilder.writeln("美国总统特朗普和国务卿蓬佩奥近日接连访问欧洲多国。两人在这些国家不遗余力推销美方立场，但欧洲国家在诸多问题上的表态与美方截然不同。对美方的指手画脚，欧洲盟友并不买账。");
        }

        {
            //插入一个段落
            Paragraph paragraph = documentBuilder.insertParagraph();
            //获取段落格式化工具
            ParagraphFormat paragraphFormat = paragraph.getParagraphFormat();
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
            paragraphFormat.setFirstLineIndent(15);
            documentBuilder.writeln("看看最新的案例。前不久，美国政府以国家安全为名，将中国高科技企业列入“实体清单”，清单上的企业或个人购买或通过转让获得美国技术需得到有关许可。出台禁令、连环封杀，动用国家机器打压他国企业，这难道就是美国政客标榜的“市场经济”“自由竞争”？美方以市场经济的卫道士自居，对其他国家的发展模式指指点点。与此同时，美国对市场经济规则进行粗暴地取舍，以实用主义态度处理国际经贸合作。这样言行不一、强买强卖，哪里符合市场经济规则，又怎能令人信服？");
        }
        doc.save(AsposeDataHelp.getPath(), SaveFormat.DOCX);
    }

    /**
     * 一个段落 并且插入文本
     *
     * @throws Exception
     */
    @Test
    public void testD() throws Exception {
        Document doc = new Document();
        DocumentBuilder documentBuilder = new DocumentBuilder(doc);
        documentBuilder.getFont().setName("微软雅黑");
        documentBuilder.getFont().setColor(Color.red);
        documentBuilder.getFont().setSize(14);
        //插入一个段落
        Paragraph paragraph = documentBuilder.insertParagraph();
        //获取段落格式化工具
        ParagraphFormat paragraphFormat = paragraph.getParagraphFormat();
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
        documentBuilder.writeln("指着屏幕上跳动的数字，贵州山久长青智慧云科技有限公司董事长杨伶说，学生今天吃了哪些食品，明天吃哪些食品，食品由哪里生产，谁进行配送、检测、加工，全都一目了然。");
        doc.save(AsposeDataHelp.getPath(), SaveFormat.DOCX);
    }

    /**
     * 段落混合 插入图片和文字
     *
     * @throws Exception
     */
    @Test
    public void testE() throws Exception {
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
        StringBuffer stringBuffer = new StringBuffer(8);
        for (int i = 0; i < 4; i++) {
            Paragraph paragraph = documentBuilder.insertParagraph();
            for (int j = 0; j < 7; j++) {
                stringBuffer.append(RandomStringUtils.random(23));
            }
            documentBuilder.write(stringBuffer.toString());
            File file = new File(FileUtils.getMainDataDir(this.getClass(), "") + "panda.png");
            documentBuilder.insertImage(new FileInputStream(file));
            stringBuffer.delete(0, stringBuffer.length());
        }
        doc.save(AsposeDataHelp.getPath(), SaveFormat.DOCX);
    }

    /**
     * 插入分页
     *
     * @throws Exception
     */
    @Test
    public void testF() throws Exception {
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
        StringBuffer stringBuffer = new StringBuffer(8);
        final int page = 4;
        for (int i = 0; i < page; i++) {
            for (int j = 0; j < 25; j++) {
                stringBuffer.append(RandomStringUtils.random(23));
            }
            documentBuilder.write(stringBuffer.toString());
            stringBuffer.delete(0, stringBuffer.length());
            if (i != page - 1) {
                documentBuilder.insertBreak(BreakType.PAGE_BREAK);
            }
        }
        doc.save(AsposeDataHelp.getPath(), SaveFormat.DOCX);
    }

    /**
     * 2个页眉 注意类型 HEADER_PRIMARY , FOOTER_PRIMARY
     *
     * @throws Exception
     */
    @Test
    public void testG1() throws Exception {
        Document doc = new Document();
        DocumentBuilder documentBuilder = new DocumentBuilder(doc);
        //获取段落格式化工具
        ParagraphFormat paragraphFormat = documentBuilder.getParagraphFormat();//可以直接从documentBuilder获取段落的格式工具
        //设置对齐
        paragraphFormat.setAlignment(ParagraphAlignment.CENTER);
        documentBuilder.getFont().setName("微软雅黑");
        documentBuilder.getFont().setColor(Color.red);

        {
            HeaderFooter headerFooter = new HeaderFooter(doc, HeaderFooterType.HEADER_PRIMARY);
            doc.getFirstSection().getHeadersFooters().add(headerFooter);
            Paragraph para = new Paragraph(doc);
            Run run = new Run(doc, "测试页眉1");
            run.getFont().setSize(9.0);
            run.getFont().setColor(Color.orange);
            para.appendChild(run);
            headerFooter.appendChild(para);
        }


        {
            HeaderFooter headerFooter = new HeaderFooter(doc, HeaderFooterType.FOOTER_PRIMARY);
            doc.getFirstSection().getHeadersFooters().add(headerFooter);
            Paragraph para = new Paragraph(doc);
            Run run = new Run(doc, "测试页眉2");
            run.getFont().setSize(12.0);
            run.getFont().setColor(Color.RED);
            para.appendChild(run);
            headerFooter.appendChild(para);
        }


        doc.save(AsposeDataHelp.getPath(), SaveFormat.DOCX);
    }

    /**
     * 页眉改进
     * 注意类型 HEADER_PRIMARY , FOOTER_PRIMARY 改进
     *
     * @throws Exception
     */
    @Test
    public void testG2() throws Exception {
        Document doc = new Document();
        DocumentBuilder documentBuilder = new DocumentBuilder(doc);
        documentBuilder.getFont().setName("微软雅黑");
        documentBuilder.getFont().setSize(10);

        {
            HeaderFooter headerFooter = new HeaderFooter(doc, HeaderFooterType.HEADER_PRIMARY);
            doc.getFirstSection().getHeadersFooters().add(headerFooter);
            Paragraph paragraph = headerFooter.appendParagraph("测试页眉1");
            paragraph.getParagraphFormat().setAlignment(ParagraphAlignment.CENTER);
            if (paragraph.getRuns().toArray().length >= 1) {
                paragraph.getRuns().get(0).getFont().setColor(Color.red);
                paragraph.getRuns().get(0).getFont().setBold(true);
            }
        }

        {
            HeaderFooter headerFooter = new HeaderFooter(doc, HeaderFooterType.FOOTER_PRIMARY);
            doc.getFirstSection().getHeadersFooters().add(headerFooter);
            Paragraph paragraph = headerFooter.appendParagraph("测试页眉2");
            paragraph.getParagraphFormat().setAlignment(ParagraphAlignment.CENTER);
        }

        doc.save(AsposeDataHelp.getPath(), SaveFormat.DOCX);
    }

    /**
     * 页脚 first
     * @throws Exception
     */
    @Test
    public void testH1() throws Exception {
        Document doc = new Document();
        DocumentBuilder documentBuilder = new DocumentBuilder(doc);

        //创建页脚 页码
        HeaderFooter footer = new HeaderFooter(doc, HeaderFooterType.FOOTER_PRIMARY);
        doc.getFirstSection().getHeadersFooters().add(footer);

        //页脚段落
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

        doc.save(AsposeDataHelp.getPath(), SaveFormat.DOCX);
    }

    @Test
    public void testH2()throws Exception{

    }

    @Test
    public void testI()throws Exception{
        DocumentBuilder builder = new DocumentBuilder();
        Document doc = builder.getDocument();
        //将光标移到目录书签
        builder.moveToBookmark("TOC");
        builder.insertBreak(BreakType.PAGE_BREAK);

        //设置目录的格式
        //获取当前段落               ==     获取当前段落样式          //设置居中
        builder.getCurrentParagraph().getParagraphFormat().setAlignment(ParagraphAlignment.CENTER);
        builder.setBold(true);
        builder.getFont().setName("微软雅黑");
        builder.writeln("目录");

        //清清除所有样式设置
        builder.getParagraphFormat().clearFormatting();
        //重新设置段落样式 目录居左
        builder.getParagraphFormat().setAlignment(ParagraphAlignment.LEFT);
        //插入目录，这是固定的
        builder.insertTableOfContents("\\o \"1-3\" \\h \\z \\u");
        // Start the actual document content on the second page. 在第二页上开始实际文档内容。
        builder.insertBreak(BreakType.SECTION_BREAK_NEW_PAGE);//分节符新页面

        //通过应用不同的标题样式来构建具有复杂结构的文档，从而创建目录项
        builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_1);//样式标识符==> 航向\1
        builder.writeln("Heading 1");
        // Call the method below to update the TOC. 调用下面的方法更新目录。
        doc.updateFields();
        doc.save(AsposeDataHelp.getPath(), SaveFormat.DOCX);
    }


    @Test
    public void readData() throws Exception {
        String path = FileUtils.getMainDataDir(AsposeDataHelp.class, "") + "example\\data\\document.doc";
        Document doc = new Document(path);

        System.out.println(doc.getSections().getCount());

        System.out.println(doc.getFirstSection().getNodeType());
        System.out.println(doc.getFirstSection().getBody().getText());
        System.out.println(doc.getFirstSection().getBody().getRange().getText());
    }

    @Test
    public void testE4848() throws Exception {
        String path = FileUtils.getMainDataDir(AsposeDataHelp.class, "") + "example\\data\\document.doc";
        Document doc = new Document(path);
        Document mainDoc = new Document();
        DocumentBuilder mainDocumentBuilder = new DocumentBuilder(mainDoc);
        SectionCollection sections = doc.getSections();
        for (int i = 0; i < sections.getCount(); i++) {
            Section section = sections.get(i);
            NodeCollection nodeCollection = section.getChildNodes();
            Node[] nodes = nodeCollection.toArray();
            for (Node srcNode : nodes) {
                NodeImporter nodeImporter = new NodeImporter(doc, mainDoc, ImportFormatMode.KEEP_SOURCE_FORMATTING);
//                Node newNode = nodeImporter.importNode(srcNode,true) ;
                mainDocumentBuilder.insertNode(srcNode);
//                mainDoc.getFirstSection().getBody().appendChild(newNode) ;
            }
        }
        mainDoc.save(AsposeDataHelp.getPath(), SaveFormat.DOCX);
    }


    /**
     * 必要的，验证码校验
     */
    @BeforeTest
    public void before() {
        AsposeUtils.checkLicense();
    }

}
