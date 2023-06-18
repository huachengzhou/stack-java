package org.poi;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.*;
import org.enums.ExcelForXSSFEnum;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * @Author zch
 * @Description 复杂excel write
 * @createDate 2018/10/2
 **/
public class ComplexExcel {

    @Test
    public void writeA()throws Exception{
        String path = String.format("%s%s%s", ExcelForXSSFEnum.A_Path.getPath(), UUID.randomUUID().toString().substring(0, 6), ".xlsx") ;
        InputStream input= new FileInputStream(path);
        XSSFWorkbook workBook=new XSSFWorkbook(input);
        XSSFSheet hssfSheet = workBook.getSheet("Sheet1");
        XSSFRow hssfRow=null;
        XSSFCell cell=null;
        XSSFFont font=workBook.createFont();
        font.setFontName("GE Inspira");

        OutputStream out=new FileOutputStream(path);
        XSSFSheet hssfSheet2 = workBook.createSheet("Sheet2");
        for (int i = 0; i < hssfSheet.getLastRowNum(); i++) {

            hssfRow=hssfSheet.getRow(i);
            XSSFRow row=hssfSheet2.createRow(i);
            for (int j = 0; j < hssfRow.getLastCellNum(); j++) {
                CellStyle style=workBook.createCellStyle();
                style.setFont(font);
                cell=hssfRow.getCell(j);
                XSSFCell cellWrite=row.createCell(j);
                if(cell.getCellType()==cell.CELL_TYPE_STRING){
                    //set value for strings
                    cellWrite.setCellValue(cell.getStringCellValue());
                    cellWrite.setCellStyle(style);
                }else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC){
                    //set Value for date
                    if(HSSFDateUtil.isCellDateFormatted(cell)){
                        DateFormat format=new SimpleDateFormat();
                        short df=workBook.createDataFormat().getFormat("yyyy-MM-dd");
                        style.setDataFormat(df);
                        cellWrite.setCellStyle(style);
                        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd");
                        String readDateValue=dateFormat.format(cell.getDateCellValue());
                        cellWrite.setCellValue(readDateValue);
                    }else{
                        //set value for numeric
                        cellWrite.setCellValue(cell.getNumericCellValue());
                        cellWrite.setCellStyle(style);
                    }
                }else if(cell.getCellType()==cell.CELL_TYPE_BLANK){
                    //set value for blank
                    cellWrite.setCellValue("");
                    cellWrite.setCellStyle(style);
                }else{
                    cellWrite.setCellValue(cell.getStringCellValue());
                    cellWrite.setCellStyle(style);
                }
            }
        }
    }

}
