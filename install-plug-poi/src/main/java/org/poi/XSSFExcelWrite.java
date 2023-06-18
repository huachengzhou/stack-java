package org.poi;

import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.enums.ExcelForXSSFEnum;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/10/6
 **/
public class XSSFExcelWrite {

    /**
     * @Description:公式
     * @Author:zch
     * @CreateDate:16:21 2018/10/6
     * @Version:1.0
     */
    @Test
    public void formula(){
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("formula");
        XSSFRow row = spreadsheet.createRow(1);
        XSSFCell cell = row.createCell(1);
        cell.setCellValue("A =" );
        cell = row.createCell(2);
        cell.setCellValue(2);
        row = spreadsheet.createRow(2);
        cell = row.createCell(1);
        cell.setCellValue("B =");
        cell = row.createCell(2);
        cell.setCellValue(4);
        row = spreadsheet.createRow(3);
        cell = row.createCell(1);
        cell.setCellValue("Total =");
        cell = row.createCell(2);
        // Create SUM formula
        cell.setCellType(XSSFCell.CELL_TYPE_FORMULA);
        cell.setCellFormula("SUM(C2:C3)" );
        cell = row.createCell(3);
        cell.setCellValue("SUM(C2:C3)");
        row = spreadsheet.createRow(4);
        cell = row.createCell(1);
        cell.setCellValue("POWER =");
        cell=row.createCell(2);
        // Create POWER formula
        cell.setCellType(XSSFCell.CELL_TYPE_FORMULA);
        cell.setCellFormula("POWER(C2,C3)");
        cell = row.createCell(3);
        cell.setCellValue("POWER(C2,C3)");
        row = spreadsheet.createRow(5);
        cell = row.createCell(1);
        cell.setCellValue("MAX =");
        cell = row.createCell(2);
        // Create MAX formula
        cell.setCellType(XSSFCell.CELL_TYPE_FORMULA);
        cell.setCellFormula("MAX(C2,C3)");
        cell = row.createCell(3);
        cell.setCellValue("MAX(C2,C3)");
        row = spreadsheet.createRow(6);
        cell = row.createCell(1);
        cell.setCellValue("FACT =");
        cell = row.createCell(2);
        // Create FACT formula
        cell.setCellType(XSSFCell.CELL_TYPE_FORMULA);
        cell.setCellFormula("FACT(C3)");
        cell = row.createCell(3);
        cell.setCellValue("FACT(C3)");
        row = spreadsheet.createRow(7);
        cell = row.createCell(1);
        cell.setCellValue("SQRT =");
        cell = row.createCell(2);
        // Create SQRT formula
        cell.setCellType(XSSFCell.CELL_TYPE_FORMULA);
        cell.setCellFormula("SQRT(C5)");
        cell = row.createCell(3);
        cell.setCellValue("SQRT(C5)");
        workbook.getCreationHelper()
                .createFormulaEvaluator()
                .evaluateAll();
        writeFile(workbook, String.format("%s%s%s", ExcelForXSSFEnum.A_Path.getPath(),"XSSFExcelWrite_formula", ".xlsx"));
    }

    /**
     * @Description:常用颜色
     * @Author:zch
     * @CreateDate:15:44 2018/10/6
     * @Version:1.0
     */
    @Test
    public void colorTest() {

        // Create a workbook object
        Workbook workbook = new XSSFWorkbook();
        // Create sheet
        Sheet sheet = workbook.createSheet();

        // Create a row and put some cells in it.
        Row row = sheet.createRow((short) 1);

        // Aqua background
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        Cell cell = row.createCell((short) 1);
        cell.setCellValue("X1");
        cell.setCellStyle(style);

        // Orange "foreground", foreground being the fill foreground not the
        // font color.
        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.AUTOMATIC.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row.createCell((short) 2);
        cell.setCellValue("X2");
        cell.setCellStyle(style);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row.createCell((short) 3);
        cell.setCellValue("X3");
        cell.setCellStyle(style);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row.createCell((short) 4);
        cell.setCellValue("X4");
        cell.setCellStyle(style);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row.createCell((short) 5);
        cell.setCellValue("X5");
        cell.setCellStyle(style);

        // Create a row and put some cells in it.
        Row row2 = sheet.createRow((short) 2);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.BROWN.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row2.createCell((short) 1);
        cell.setCellValue("X6");
        cell.setCellStyle(style);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.CORAL.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row2.createCell((short) 2);
        cell.setCellValue("X7");
        cell.setCellStyle(style);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.CORNFLOWER_BLUE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row2.createCell((short) 3);
        cell.setCellValue("X8");
        cell.setCellStyle(style);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row2.createCell((short) 4);
        cell.setCellValue("X9");
        cell.setCellStyle(style);
        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.DARK_GREEN.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row2.createCell((short) 5);
        cell.setCellValue("X10");
        cell.setCellStyle(style);

        // Create a row and put some cells in it.
        Row row3 = sheet.createRow((short) 3);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.DARK_RED.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row3.createCell((short) 1);
        cell.setCellValue("X11");
        cell.setCellStyle(style);
        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.DARK_TEAL.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row3.createCell((short) 2);
        cell.setCellValue("X12");
        cell.setCellStyle(style);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.DARK_YELLOW.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row3.createCell((short) 3);
        cell.setCellValue("X13");
        cell.setCellStyle(style);
        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GOLD.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row3.createCell((short) 4);
        cell.setCellValue("X14");
        cell.setCellStyle(style);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row3.createCell((short) 5);
        cell.setCellValue("X15");
        cell.setCellStyle(style);

        // Create a row and put some cells in it.
        Row row4 = sheet.createRow((short) 4);
        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row4.createCell((short) 1);
        cell.setCellValue("X16");
        cell.setCellStyle(style);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row4.createCell((short) 2);
        cell.setCellValue("X17");
        cell.setCellStyle(style);
        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row4.createCell((short) 3);
        cell.setCellValue("X18");
        cell.setCellStyle(style);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row4.createCell((short) 4);
        cell.setCellValue("X19");
        cell.setCellStyle(style);
        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.INDIGO.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row4.createCell((short) 5);
        cell.setCellValue("X20");
        cell.setCellStyle(style);

        // Create a row and put some cells in it.
        Row row5 = sheet.createRow((short) 5);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LAVENDER.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row5.createCell((short) 1);
        cell.setCellValue("X21");
        cell.setCellStyle(style);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LEMON_CHIFFON.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row5.createCell((short) 2);
        cell.setCellValue("X22");
        cell.setCellStyle(style);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row5.createCell((short) 3);
        cell.setCellValue("X23");
        cell.setCellStyle(style);
        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LEMON_CHIFFON.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row5.createCell((short) 4);
        cell.setCellValue("X24");
        cell.setCellStyle(style);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row5.createCell((short) 5);
        cell.setCellValue("X25");
        cell.setCellStyle(style);

        // Create a row and put some cells in it.
        Row row6 = sheet.createRow((short) 6);
        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE
                .getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row6.createCell((short) 1);
        cell.setCellValue("X26");
        cell.setCellStyle(style);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row6.createCell((short) 2);
        cell.setCellValue("X27");
        cell.setCellStyle(style);
        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row6.createCell((short) 3);
        cell.setCellValue("X28");
        cell.setCellStyle(style);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row6.createCell((short) 4);
        cell.setCellValue("X29");
        cell.setCellStyle(style);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row6.createCell((short) 5);
        cell.setCellValue("X30");
        cell.setCellStyle(style);

        // Create a row and put some cells in it.
        Row row7 = sheet.createRow((short) 7);
        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIME.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row7.createCell((short) 1);
        cell.setCellValue("X31");
        cell.setCellStyle(style);
        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.MAROON.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row7.createCell((short) 2);
        cell.setCellValue("X32");
        cell.setCellStyle(style);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.OLIVE_GREEN.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row7.createCell((short) 3);
        cell.setCellValue("X33");
        cell.setCellStyle(style);
        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row7.createCell((short) 4);
        cell.setCellValue("X34");
        cell.setCellStyle(style);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.ORCHID.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row7.createCell((short) 5);
        cell.setCellValue("X35");
        cell.setCellStyle(style);

        // Create a row and put some cells in it.
        Row row8 = sheet.createRow((short) 8);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row8.createCell((short) 1);
        cell.setCellValue("X36");
        cell.setCellStyle(style);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.PINK.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row8.createCell((short) 2);
        cell.setCellValue("X37");
        cell.setCellStyle(style);
        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.PLUM.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row8.createCell((short) 3);
        cell.setCellValue("X38");
        cell.setCellStyle(style);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row8.createCell((short) 4);
        cell.setCellValue("X39");
        cell.setCellStyle(style);
        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.ROSE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row8.createCell((short) 5);
        cell.setCellValue("X40");
        cell.setCellStyle(style);

        // Create a row and put some cells in it.
        Row row9 = sheet.createRow((short) 9);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row9.createCell((short) 1);
        cell.setCellValue("X41");
        cell.setCellStyle(style);
        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row9.createCell((short) 2);
        cell.setCellValue("X42");
        cell.setCellStyle(style);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row9.createCell((short) 3);
        cell.setCellValue("X43");
        cell.setCellStyle(style);
        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.TAN.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row9.createCell((short) 4);
        cell.setCellValue("X44");
        cell.setCellStyle(style);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.TEAL.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row9.createCell((short) 5);
        cell.setCellValue("X45");
        cell.setCellStyle(style);

        // Create a row and put some cells in it.
        Row row10 = sheet.createRow((short) 10);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.TURQUOISE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row10.createCell((short) 1);
        cell.setCellValue("X46");
        cell.setCellStyle(style);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.VIOLET.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row10.createCell((short) 2);
        cell.setCellValue("X47");
        cell.setCellStyle(style);
        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row10.createCell((short) 3);
        cell.setCellValue("X48");
        cell.setCellStyle(style);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row10.createCell((short) 3);
        cell.setCellValue("X49");
        cell.setCellStyle(style);
        writeFile(workbook, String.format("%s%s%s", ExcelForXSSFEnum.A_Path.getPath(),"XSSFExcelWrite_color_final", ".xlsx"));
    }

    /**
     * @Description:常用链接
     * @Author:zch
     * @CreateDate:15:44 2018/10/6
     * @Version:1.0
     */
    @Test
    public void writeLink() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook
                .createSheet("Hyperlinks");
        XSSFCell cell;
        CreationHelper createHelper = workbook
                .getCreationHelper();
        XSSFCellStyle hlinkstyle = workbook.createCellStyle();
        XSSFFont hlinkfont = workbook.createFont();
        hlinkfont.setUnderline(XSSFFont.U_SINGLE);
        hlinkfont.setColor(HSSFColor.BLUE.index);
        hlinkstyle.setFont(hlinkfont);
        //URL Link
        cell = spreadsheet.createRow(1)
                .createCell((short) 1);
        cell.setCellValue("URL Link");
        XSSFHyperlink link = (XSSFHyperlink) createHelper
                .createHyperlink(Hyperlink.LINK_URL);
        link.setAddress("https://blog.csdn.net/liberty12345678/article/details/82109514");
        cell.setHyperlink((XSSFHyperlink) link);
        cell.setCellStyle(hlinkstyle);
        //Hyperlink to a file in the current directory
        cell = spreadsheet.createRow(2)
                .createCell((short) 1);
        cell.setCellValue("File Link");
        link = (XSSFHyperlink) createHelper
                .createHyperlink(Hyperlink.LINK_FILE);
        link.setAddress("cellstyle.xlsx");
        cell.setHyperlink(link);
        cell.setCellStyle(hlinkstyle);
        //e-mail link
        cell = spreadsheet.createRow(3)
                .createCell((short) 1);
        cell.setCellValue("Email Link");
        link = (XSSFHyperlink) createHelper
                .createHyperlink(Hyperlink.LINK_EMAIL);
        link.setAddress(
                "mailto:contact@yiibai.com?"
                        + "subject=Hyperlink");
        cell.setHyperlink(link);
        cell.setCellStyle(hlinkstyle);
        writeFile(workbook, String.format("%s%s%s", ExcelForXSSFEnum.A_Path.getPath(), "XSSFExcelWrite_link", ".xlsx"));
    }

    private void writeFile(Workbook workbook, String path) {
        try {
            File file = new File(path);
            FileOutputStream fileoutputStream = new FileOutputStream(file);
            workbook.write(fileoutputStream);
            fileoutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
