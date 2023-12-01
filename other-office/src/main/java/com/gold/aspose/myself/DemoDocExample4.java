package com.gold.aspose.myself;

import com.aspose.words.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class DemoDocExample4 {

    private static final Logger logger = LoggerFactory.getLogger(DemoDocExample4.class);

    /**
     * 一个  可以自动生成目录和页眉 页脚的方法
     *
     * @throws Exception
     */
    @org.testng.annotations.Test
    public void test1() throws Exception {
        Document document = new Document();

        final int length = 6;
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                document = new Document(toDoc());
            } else {
                document.appendDocument(new Document(toDoc()), ImportFormatMode.USE_DESTINATION_STYLES);
            }
        }

        DocumentBuilder builder = new DocumentBuilder(document);

        builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_1);
        builder.writeln("目录");

        String switches = String.format("\\o \"1-%d\" \\h \\z \\u", length);
        builder.insertTableOfContents(switches);
        document.updateFields();
        builder.insertBreak(BreakType.PAGE_BREAK);


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

        document.updateFields();


        //5:页眉页脚
        String text = "这就是人生";
        HeaderFooter header = new HeaderFooter(document, HeaderFooterType.HEADER_PRIMARY);
        document.getFirstSection().getHeadersFooters().add(header);
        Paragraph headerParagraph = new Paragraph(document);
        headerParagraph.getParagraphFormat().setAlignment(ParagraphAlignment.CENTER);
        //设置文字
        headerParagraph.appendChild(this.getDefaultHeaderFooterRun(document, text));
        header.appendChild(headerParagraph);
        //页脚
        HeaderFooter footer = new HeaderFooter(document, HeaderFooterType.FOOTER_PRIMARY);
        document.getFirstSection().getHeadersFooters().add(footer);
        Paragraph footerParagraph = new Paragraph(document);
        footerParagraph.getParagraphFormat().setAlignment(ParagraphAlignment.CENTER);
        //设置页码
        footerParagraph.appendChild(this.getDefaultHeaderFooterRun(document, "第 "));
        footerParagraph.appendField(FieldType.FIELD_PAGE, true);//当前页
        footerParagraph.appendChild(this.getDefaultHeaderFooterRun(document, " 页，共 "));
        footerParagraph.appendField(FieldType.FIELD_NUM_PAGES, true);//总页数
        footerParagraph.appendChild(this.getDefaultHeaderFooterRun(document, " 页 "));
        footer.appendChild(footerParagraph);


        //下面的update 是更新目录页码问题
        document.updateFields();
        document.updatePageLayout();
        document.updateTableLayout();

        String dir = getProjectPath() + File.separator + "xx";
        File file = new File(dir);
        if (!file.isDirectory()) {
            file.mkdirs();
        }

        String path = file.getPath() + File.separator + UUID.randomUUID().toString().substring(0, 8) + ".docx";
        document.save(path);
        System.out.println(path);
    }


    /**
     * 生成文档
     *
     * @return
     * @throws Exception
     */
    public String toDoc() throws Exception {
        Document doc = new Document();
        DocumentBuilder documentBuilder = new DocumentBuilder(doc);


        documentBuilder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_2);
//        documentBuilder.writeln(String.valueOf(RandomUtils.nextLong(4, 50)));
        documentBuilder.writeln(RandomStringUtils.randomAlphabetic(10));


        // 里面的 paragraphFormat.clearFormatting(); 非常重要
        setDefaultTable(documentBuilder);
        LinkedList<String> titles = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                titles.add(j % 2 == 0 ? String.valueOf(RandomUtils.nextDouble(300, 1000)) : String.valueOf(RandomUtils.nextLong(200, 5000)));
            }
            writeWordTitle(documentBuilder, titles);
            titles.clear();
        }

        String dir = getProjectPath() + File.separator + "xx";
        File file = new File(dir);
        if (!file.isDirectory()) {
            file.mkdirs();
        }

        String fileName = file.getPath() + File.separator + UUID.randomUUID().toString().substring(0, 8) + ".docx";
        doc.save(fileName);
        return fileName;
    }


    public static void setDefaultTable(DocumentBuilder documentBuilder) {
        //设置具体宽度自动适应
        ParagraphFormat paragraphFormat = documentBuilder.getParagraphFormat();
        paragraphFormat.clearFormatting();

        PreferredWidth preferredWidth = PreferredWidth.AUTO;
        documentBuilder.getParagraphFormat().setAlignment(ParagraphAlignment.CENTER);
        documentBuilder.getCellFormat().setPreferredWidth(preferredWidth);
        documentBuilder.getCellFormat().setVerticalMerge(CellVerticalAlignment.CENTER);
        documentBuilder.getCellFormat().setVerticalAlignment(CellVerticalAlignment.CENTER);
        documentBuilder.getCellFormat().setHorizontalMerge(CellVerticalAlignment.CENTER);
        documentBuilder.getCellFormat().setTopPadding(0);
        documentBuilder.getCellFormat().setBottomPadding(0);
        documentBuilder.getCellFormat().setLeftPadding(0);
        documentBuilder.getCellFormat().setRightPadding(0);


        try {
            Style style = paragraphFormat.getStyle();
            style.getFont().setBold(false);
            style.getFont().setBoldBi(false);
            style.getFont().setBidi(false);
//            style.getFont().setSize(12);
//            style.getFont().setName("微软雅黑");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }


    public static void writeWordTitle(DocumentBuilder builder, List<String> titles) throws Exception {
        if (CollectionUtils.isNotEmpty(titles)) {
            for (String title : titles) {
                builder.insertCell();
                builder.write(title);
            }
            builder.endRow();
        }
    }

    private Run getDefaultHeaderFooterRun(Document doc, String text) throws Exception {
        Run run = new Run(doc);
        Font font = run.getFont();
        font.setName("宋体");
        font.setSize(9);
        run.setText(text);
        return run;
    }

    public String getProjectPath() {
        String separator = File.separator;
        String baseDir = "src" + separator + "main" + separator + "java";
        String page = getClass().getPackage().getName();
        String[] strings = page.split("\\.");
        return System.getProperty("user.dir") + separator + baseDir + separator + String.join(separator, strings);
    }

    @org.testng.annotations.Test
    public void test2() {
        String projectPath = getProjectPath();
        System.out.println(projectPath);
    }

}
