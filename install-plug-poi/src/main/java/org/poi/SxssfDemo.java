package org.poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @Author nealin
 * @Date 2019/6/19 15:36
 * @Version 1.0
 *借助临时存储空间生成海量excel数据
 */
public class SxssfDemo {
    public void write(String filePath, List<List<String>> data) throws Exception {
        SXSSFWorkbook wb = new SXSSFWorkbook(-1);
        Sheet sh = wb.createSheet();
        for(int rownum = 0; rownum < data.size(); rownum++){
            Row row = sh.createRow(rownum);
            for(int cellnum = 0; cellnum < data.get(rownum).size(); cellnum++){
                Cell cell = row.createCell(cellnum);
                cell.setCellValue(data.get(rownum).get(cellnum));
            }
            if(rownum % 100 == 0) {
                ((SXSSFSheet)sh).flushRows(100);
            }
        }
        FileOutputStream out = new FileOutputStream(filePath);
        wb.write(out);
        out.close();
        wb.dispose();
    }
}
