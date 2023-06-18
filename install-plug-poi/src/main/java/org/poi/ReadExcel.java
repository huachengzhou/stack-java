package org.poi;

import com.google.common.collect.Lists;
import org.PoiUtils;
import org.apache.poi.ss.usermodel.*;
import org.enums.ExcelForXSSFEnum;
import org.po.HouseExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/9/24
 **/
public class ReadExcel {
    private Logger logger = LoggerFactory.getLogger(getClass()) ;

    @Test
    public void readHouseExample() {
        String path = String.format("%s%s", ExcelForXSSFEnum.A_Path.getPath(), "HouseExample.xlsx");
        InputStream inputStream = null;
        Workbook workbook = null;
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        List<HouseExample> examples = Lists.newArrayList();
        try {
            inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheetAt(0);
            int startRowIndex = 1;
            int startColIndex = 1;
            //总行数
            int rowLength = sheet.getLastRowNum() ;
            //物理读法
            // int  rowLength  =  sheet.getPhysicalNumberOfRows()  !=  0  ?  sheet.getPhysicalNumberOfRows()  :  sheet.getLastRowNum();
            //总列数
            int colLength = sheet.getRow(0).getLastCellNum() - startColIndex;
            //物理读法
            // int  colLength  =  row.getPhysicalNumberOfCells()  !=  0  ?  row.getPhysicalNumberOfCells()  :  row.getLastCellNum();
            for (int i = startRowIndex; i <= rowLength; i++) {
                row = sheet.getRow(i);
                for (int j = startColIndex; j < colLength; j++) {
                    if (row != null) {
                        HouseExample houseExample = new HouseExample();
                        if (j == 1){
                            houseExample.setRealEstateWarrantNo(PoiUtils.getCellValue(row.getCell(j)));
                        }
                        if (j == 2){
                            houseExample.setLocation(PoiUtils.getCellValue(row.getCell(j)));
                        }
                        examples.add(houseExample);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {

            }
        }
        if (!ObjectUtils.isEmpty(examples)){
            for (HouseExample oo:examples){
                System.out.println(oo);
            }
        }
    }

    @Test
    public void readA() {
        File file = new File(ExcelForXSSFEnum.A_Path.getPath() + "工作簿V.xlsx");
        InputStream inputStream = null;
        Workbook workbook = null;
        if (file.exists()) {
            try {
                inputStream = new FileInputStream(file);
                workbook = WorkbookFactory.create(inputStream);
                inputStream.close();
                //工作表对象
                Sheet sheet = workbook.getSheetAt(0);
                //总行数
                int rowLength = sheet.getLastRowNum() + 1;
                //工作表的第一行
                Row row = sheet.getRow(0);
                //总列数
                int colLength = row.getLastCellNum();

            } catch (Exception e) {
                logger.info(e.getMessage());
            }
        }
    }

}
