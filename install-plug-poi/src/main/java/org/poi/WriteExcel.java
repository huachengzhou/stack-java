package org.poi;

import org.DateUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.enums.ExcelForXSSFEnum;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @Author zch
 * @Description poi version 3.9
 * @createDate 2018/9/24
 **/
public class WriteExcel {

    /**
     * 说明:XSSF == > xlsx
     * HSSF == > xls
     * (即使你在创建电子表格的时候没有用到诸如HSSFWorkbook或者HSSFWorkbook等类似前缀,
     * 但在生成excel的时候依旧会转成类似的HSSFWorkbook或者HSSFWorkbook)这样就容易出现类型转换错误
     * HSSF是POI对Excel-97（-2007）文件操作的纯Java实现。
     * XSSF是POI对Excel 2007 OOXML（.xlsx）文件操作的纯Java实现。从POI 3.8版本开始，提供了一种基于XSSF的低内存占用的API（SXSSF）。
     */
    /**
     * 临时网址:
     * https://blog.csdn.net/liberty12345678/article/details/82109514
     * https://poi.apache.org/apidocs/index.html
     * https://www.yiibai.com/apache_poi/apache_poi_core_classes.html
     * https://www.w3cschool.cn/apache_poi_word/apache_poi_word_tables.html
     */

    @Test
    public void print(){
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        CellStyle style = null;
        sheet = workbook.createSheet(RandomStringUtils.random(7));
        style = workbook.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);//居中
        Font font = workbook.createFont();
        font.setColor(IndexedColors.RED.index);
        style.setFont(font);
        //设置单元格的默认宽度
        sheet.setDefaultColumnWidth(20);
        //设置打印区域
        workbook.setPrintArea(0,1,20,1,20);
        // //set paper size
        sheet.getPrintSetup().setPaperSize(PrintSetup.A4_EXTRA_PAPERSIZE);

        //set display grid lines or not (是否设置显示网格线 )
        sheet.setDisplayGridlines(true);
        //set print grid lines or not (是否设置打印网格线 )
        sheet.setPrintGridlines(true);

        for (int j = 1; j < 20; j++) {
            row = sheet.createRow(j);
            for (int i = 1; i < 20; i++) {
                cell = row.createCell(i);
                cell.setCellStyle(style);
                cell.setCellValue(RandomUtils.nextDouble(10, 100.04d));
            }
        }
        writeFile(workbook, String.format("%s%s%s", ExcelForXSSFEnum.A_Path.getPath(), UUID.randomUUID().toString().substring(1, 6), ".xlsx"));
    }

    /**
     * @Description:插入图片 按比例
     * @Author:zch
     * @CreateDate:17:01 2018/10/6
     * @Version:1.0
     */
    @Test
    public void writeImg2()throws Exception {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        CellStyle style = null;
        sheet = workbook.createSheet(RandomStringUtils.random(5));
        style = workbook.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);//居中
        FileOutputStream fileOut = null;
        BufferedImage bufferImg = null;
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
        bufferImg = ImageIO.read(new File("E:\\lib\\panda.png"));
        ImageIO.write(bufferImg, "png", byteArrayOut);


        int pictureIdx = workbook.addPicture(byteArrayOut.toByteArray(), Workbook.PICTURE_TYPE_PNG);
        CreationHelper helper = sheet.getWorkbook().getCreationHelper();
        ClientAnchor anchor = helper.createClientAnchor();
        Drawing patriarch = sheet.createDrawingPatriarch();
        // 图片插入坐标
        anchor.setCol1(2);
        anchor.setRow1(2);

        // 使用固定的长宽比例系数
        double a = 5.9;
        double b = 1;

        // 插入图片
        Picture pict = patriarch.createPicture(anchor, pictureIdx);
//        pict.resize(a/b);
        pict.resize();//自动调整结束的位置
        writeFile(workbook, String.format("%s%s%s", ExcelForXSSFEnum.A_Path.getPath(), UUID.randomUUID().toString().substring(1, 6), ".xlsx"));
    }

    /**
     * @Description:插入图片 固定位置
     * @Author:zch
     * @CreateDate:17:01 2018/10/6
     * @Version:1.0
     */
    @Test
    public void writeImg1()throws Exception {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        CellStyle style = null;
        sheet = workbook.createSheet(RandomStringUtils.random(5));
        style = workbook.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);//居中
        FileOutputStream fileOut = null;
        BufferedImage bufferImg = null;
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
        bufferImg = ImageIO.read(new File("E:\\lib\\panda.png"));
        ImageIO.write(bufferImg, "png", byteArrayOut);

        Drawing patriarch = sheet.createDrawingPatriarch();
        int pictureIdx = workbook.addPicture(byteArrayOut.toByteArray(), Workbook.PICTURE_TYPE_PNG);
        ClientAnchor anchor = patriarch.createAnchor(0, 0, 1023, 255,
                2,
                1,
                7,
                7
        );
        patriarch.createPicture(anchor, pictureIdx);
        writeFile(workbook, String.format("%s%s%s", ExcelForXSSFEnum.A_Path.getPath(), UUID.randomUUID().toString().substring(1, 6), ".xlsx"));
    }


    /**
     * @Description: excel 公式
     * @Author:zch
     * @CreateDate:17:00 2018/10/6
     * @Version:1.0
     */
    @Test
    public void writeFormula() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        CellStyle style = null;
        sheet = workbook.createSheet(RandomStringUtils.random(5));
        style = workbook.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);//居中
        //设置单元格的默认宽度
        sheet.setDefaultColumnWidth(20);

        for (int j = 2; j < 5; j++) {
            row = sheet.createRow(j);
            for (int i = 2; i < 7; i++) {
                cell = row.createCell(i);
                cell.setCellStyle(style);
                cell.setCellValue(RandomUtils.nextDouble(10, 100.04d));
            }
        }

        for (int j = 2; j < 5; j++) {
            row = sheet.getRow(j);
            for (int i = 7; i < 9; i++) {
                cell = row.createCell(i);
                cell.setCellStyle(style);
                if (j == 2) {
                    if (i == 7) {
                        cell.setCellValue("sum(累加)");//累加
                    }
                    if (i == 8) {
                        cell.setCellType(Cell.CELL_TYPE_FORMULA);//设置单元格类型为公式
                        cell.setCellFormula("SUM(C3:G3)");
                    }
                }

                if (j == 3) {
                    if (i == 7) {
                        cell.setCellValue("PRODUCT(相乘)");//相乘
                    }
                    if (i == 8) {
                        cell.setCellType(Cell.CELL_TYPE_FORMULA);//设置单元格类型为公式
                        cell.setCellFormula("PRODUCT(C4,G4)");
                    }
                }

                if (j == 4) {
                    if (i == 7) {
                        cell.setCellValue("MAX(最大值)");//最大值
                    }
                    if (i == 8) {
                        cell.setCellType(Cell.CELL_TYPE_FORMULA);//设置单元格类型为公式
                        cell.setCellFormula("MAX(C5:G5)");
                    }
                }
            }
        }

        writeFile(workbook, String.format("%s%s%s", ExcelForXSSFEnum.A_Path.getPath(), UUID.randomUUID().toString().substring(1, 6), ".xlsx"));
    }


    /**
     * @Description:多个 sheet
     * @Author:zch
     * @CreateDate:17:23 2018/10/6
     * @Version:1.0
     */
    @Test
    public void writeG() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        CellStyle style = null;
        sheet = workbook.createSheet(RandomStringUtils.random(5));
        style = workbook.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);//居中
        //设置单元格的默认宽度
        sheet.setDefaultColumnWidth(20);
        for (int j = 1; j < 5; j++) {
            row = sheet.createRow(j);
            for (int i = 1; i < 7; i++) {
                cell = row.createCell(i);
                cell.setCellStyle(style);
                cell.setCellValue(RandomStringUtils.random(6));
            }
        }

        sheet = workbook.createSheet(RandomStringUtils.random(5));
        //设置单元格的默认宽度
        sheet.setDefaultColumnWidth(20);
        for (int j = 2; j < 5; j++) {
            row = sheet.createRow(j);
            for (int i = 1; i < 7; i++) {
                cell = row.createCell(i);
                cell.setCellStyle(style);
                cell.setCellValue(RandomStringUtils.random(7));
            }
        }
        writeFile(workbook, String.format("%s%s%s", ExcelForXSSFEnum.A_Path.getPath(), UUID.randomUUID().toString().substring(1, 6), ".xlsx"));
    }

    /**
     * @Description: 链接
     * @Author:zch
     * @CreateDate:10:32 2018/10/6
     * @Version:1.0
     */
    @Test
    public void writeLink() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("0");
        //设置单元格的默认宽度
        sheet.setDefaultColumnWidth(20);
        Row row = null;
        Cell cell = null;
        CellStyle style = null;
        Font font = null;
        CreationHelper creationHelper = workbook.getCreationHelper();
        Hyperlink hyperlink = creationHelper.createHyperlink(Hyperlink.LINK_URL);
        hyperlink.setAddress("https://www.yiibai.com/apache_poi/apache_poi_hyperlink.html");
//        hyperlink.setFirstColumn(4);
//        hyperlink.setLastColumn(4);
//        hyperlink.setFirstRow(2);
//        hyperlink.setLastRow(2);
        style = workbook.createCellStyle();
        font = workbook.createFont();
        font.setStrikeout(true);
        style.setFont(font);
        for (int j = 1; j < 5; j++) {
            row = sheet.createRow(j);
            for (int i = 1; i < 7; i++) {
                cell = row.createCell(i);
                if (j == 2) {
                    cell.setHyperlink(hyperlink);
                    cell.setCellStyle(style);
                } else {
                    cell.setCellValue(RandomStringUtils.random(8));
                }
            }
        }
        writeFile(workbook, String.format("%s%s%s", ExcelForXSSFEnum.A_Path.getPath(), UUID.randomUUID().toString().substring(0, 6), ".xlsx"));
    }


    /**
     * @Description:描述 字体和字体样式 (字体角度,标题)
     * @Author:zch
     * @CreateDate:14:58 2018/10/2
     * @Version:1.0
     */
    @Test
    public void writeF() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("0");
        //设置单元格的默认宽度
        sheet.setDefaultColumnWidth(20);
        Row row = null;
        Cell cell = null;
        CellStyle style = null;

        row = sheet.createRow(3);

        cell = row.createCell(2);
        style = workbook.createCellStyle();
        //设置字体角度 0
        style.setRotation((short) 0);
        cell.setCellValue("0D angle");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        style = workbook.createCellStyle();
        style.setRotation((short) 90);
        cell.setCellValue("90D angle");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        style = workbook.createCellStyle();
        style.setRotation((short) 120);
        cell.setCellValue("120D angle");
        cell.setCellStyle(style);

        row = sheet.createRow(4);

        cell = row.createCell(2);
        style = workbook.createCellStyle();
        style.setRotation((short) 180);
        cell.setCellValue("180D angle");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        style = workbook.createCellStyle();
        style.setRotation((short) 270);
        cell.setCellValue("270D angle");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        style = workbook.createCellStyle();
        style.setRotation((short) 360);
        cell.setCellValue("360D angle");
        cell.setCellStyle(style);

        Font redFont = workbook.createFont();
        redFont.setColor(IndexedColors.RED.index);// 红色
        Font blueFont = workbook.createFont();
//        redFont.setColor(IndexedColors.CORNFLOWER_BLUE.index);// 蓝色
        //创建富文本字符串，内容为：Hello，World！
        String finalStr = "Hello, World!";
        RichTextString richString = new XSSFRichTextString(finalStr);
        //对"Hello,"设置redFont字体
        richString.applyFont(0, finalStr.length() - 4, redFont);  //如果不区分，可以去掉 0，6 数字
        //对"World!"设置blueFont字体
        richString.applyFont(finalStr.length() - 4, finalStr.length(), blueFont);
        row = sheet.createRow(2);
        cell = row.createCell(3);
        cell.setCellValue(richString);
        writeFile(workbook, String.format("%s%s%s", ExcelForXSSFEnum.A_Path.getPath(), UUID.randomUUID().toString().substring(0, 6), ".xlsx"));
    }

    /**
     * @Description:描述 字体和字体样式 ( 字体大小,类型,颜色,边框)
     * @Author:zch
     * @CreateDate:14:43 2018/10/2
     * @Version:1.0
     */
    @Test
    public void writeE() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("0");
        //设置单元格的默认宽度
        sheet.setDefaultColumnWidth(20);
        Row row = null;
        Cell cell = null;
        CellStyle style = workbook.createCellStyle();
        //设置字体
        Font font = workbook.createFont();
        //字体大小
        font.setFontHeightInPoints((short) 30);
        //字体的名称 ( Arial, Impact, Times New Roman ,宋体 ,黑体 ,微软雅黑 等) 这里最好是使用常见字体,因为每个人的电脑装的非常用字体可能不一致
//        font.setFontName("IMPACT");
        font.setFontName("宋体");
        font.setItalic(true);
        //字体颜色
        font.setColor(IndexedColors.CORNFLOWER_BLUE.index);
        style.setFont(font);

        row = sheet.createRow(4);
        cell = row.createCell(3);
        cell.setCellValue("region english");
        cell = row.createCell(4);
        cell.setCellValue("region chinese");

        row = sheet.createRow(5);
        cell = row.createCell(3);
        cell.setCellStyle(style);
        cell.setCellValue("taiwan");
        cell = row.createCell(4);
        cell.setCellValue("台湾");
        cell.setCellStyle(style);

        row = sheet.createRow(6);
        cell = row.createCell(3);
        style = workbook.createCellStyle();
        font = workbook.createFont();
        style.setFont(font);
        //设置删除线   strikeout（删除线）
        font.setStrikeout(true);
        font.setColor(IndexedColors.YELLOW.index);
        style.setFont(font);
        cell.setCellStyle(style);
        cell.setCellValue("beijing");

        style = workbook.createCellStyle();
        //设置上下左右四个边框宽度

        style.setBorderTop(CellStyle.BORDER_THIN);

        style.setBorderBottom(CellStyle.BORDER_THIN);

        style.setBorderLeft(CellStyle.BORDER_THIN);

        style.setBorderRight(CellStyle.BORDER_THIN);

        //设置上下左右四个边框颜色

        style.setTopBorderColor(IndexedColors.RED.index);
        style.setBottomBorderColor(IndexedColors.BLACK.index);
        style.setLeftBorderColor(IndexedColors.BLUE_GREY.index);
        style.setRightBorderColor(IndexedColors.GOLD.index);
        style.setAlignment(CellStyle.ALIGN_CENTER);//居中
        style.setWrapText(true);//设置自动换行
        font = workbook.createFont();
        style.setFont(font);
        //设置是否斜体
        font.setItalic(true);
        //设置下滑线   1:有下滑线 0：没有
        font.setUnderline((byte) 1);
        cell = row.createCell(4);
        cell.setCellValue("北京");
        cell.setCellStyle(style);
        writeFile(workbook, String.format("%s%s%s", ExcelForXSSFEnum.A_Path.getPath(), UUID.randomUUID().toString().substring(0, 6), ".xlsx"));
    }

    /**
     * @Description:描述 java 行高和默认列宽度设置
     * @Author:zch
     * @CreateDate:14:42 2018/10/2
     * @Version:1.0
     */
    @Test
    public void writeD() throws Exception {
        int startCol = 5;
        int lastCol = 12;
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("0");
        //设置单元格的默认宽度
        sheet.setDefaultColumnWidth(20);
        Row row = null;
        Cell cell = null;
        for (int i = 3; i < 20; i++) {
            row = sheet.createRow(i);
            //设置行高
            row.setHeight((short) 324);
            //这个就是合并单元格
            // 参数说明：1：开始行 2：结束行  3：开始列 4：结束列/
            // 比如我要合并 第二行到第四行的    第六列到第八列
            for (int j = startCol; j < 10; j++) {
                cell = row.createCell(j);
                if (j % 2 == 0) {
                    cell.setCellValue(DateUtils.format(new Date()));
                } else {
                    cell.setCellValue(UUID.randomUUID().toString());
                }
            }
            if (i > 4) {
                sheet.addMergedRegion(new CellRangeAddress(i, i, startCol, startCol + 3));
            }
        }
        sheet.addMergedRegion(new CellRangeAddress(3, 6, startCol + 4, startCol + 5));
        writeFile(workbook, String.format("%s%s%s", ExcelForXSSFEnum.A_Path.getPath(), UUID.randomUUID().toString().substring(0, 6), ".xlsx"));
    }

    /**
     * @Description:描述 单元格合并 (简单使用)
     * @Author:zch
     * @CreateDate:12:07 2018/10/2
     * @Version:1.0
     */
    @Test
    public void writeC() throws Exception {
        int startCol = 5;
        int lastCol = 12;
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("0");
        Row row = null;
        Cell cell = null;
        CellStyle cellStyle = workbook.createCellStyle();
        for (int i = 3; i < 20; i++) {
            row = sheet.createRow(i);
            //这个就是合并单元格
            // 参数说明：1：开始行 2：结束行  3：开始列 4：结束列
            // 比如我要合并 第二行到第四行的    第六列到第八列
            for (int j = startCol; j < 10; j++) {
                cell = row.createCell(j);
                if (j % 2 == 0) {
                    cell.setCellValue(DateUtils.format(new Date(), "YYYY-MM-DD:MM"));
                } else {
                    cell.setCellValue(UUID.randomUUID().toString());
                }
            }
            if (i > 4) {
                sheet.addMergedRegion(new CellRangeAddress(i, i, startCol, startCol + 3));
            }
        }
        sheet.addMergedRegion(new CellRangeAddress(3, 6, startCol + 4, startCol + 5));
        writeFile(workbook, String.format("%s%s%s", ExcelForXSSFEnum.A_Path.getPath(), UUID.randomUUID().toString().substring(0, 6), ".xlsx"));
    }

    /**
     * @Description:描述 创建多行表格
     * @Author:zch
     * @CreateDate:12:04 2018/10/2
     * @Version:1.0
     */
    @Test
    public void writeB() throws Exception {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(UUID.randomUUID().toString());
        Row row = null;
        Cell cell = null;
        for (int i = 3; i < 20; i++) {
            row = sheet.createRow(i);
            for (int j = 5; j < 10; j++) {
                cell = row.createCell(j);
                if (j % 2 == 0) {
                    cell.setCellValue(DateUtils.format(new Date(), "YYYY-MM-DD"));
                } else {
                    cell.setCellValue(UUID.randomUUID().toString());
                }
            }
        }
        writeFile(workbook, String.format("%s%s%s", ExcelForXSSFEnum.A_Path.getPath(), UUID.randomUUID().toString().substring(0, 6), ".xlsx"));
    }


    /**
     * @Description:描述 初步使用
     * @Author:zch
     * @CreateDate:11:56 2018/10/2
     * @Version:1.0
     */
    @Test
    public void writeA() {
        Workbook workbook = new XSSFWorkbook();
        //创建一个电子表单
        Sheet sheet = workbook.createSheet(UUID.randomUUID().toString());
        Row row = null;
        //创建行 索引为0
        row = sheet.createRow(0);
        row.createCell(1).setCellValue("姓名");

        row.createCell(2).setCellValue("年龄");

        //创建行 索引为0
        row = sheet.createRow(1);
        row.createCell(1).setCellValue("李世民");

        row.createCell(2).setCellValue(new Random().nextInt(100));

        //设置表单名称
        workbook.setSheetName(0, "信息");
        writeFile(workbook, String.format("%s%s%s", ExcelForXSSFEnum.A_Path.getPath(), "helloWorld", ".xlsx"));
    }

    private void writeFile(Workbook workbook, String path) {
        try {
            File file = new File(path);
//            file.mkdirs();
//            file.mkdir();
            FileOutputStream fileoutputStream = new FileOutputStream(file);
            workbook.write(fileoutputStream);
            fileoutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
