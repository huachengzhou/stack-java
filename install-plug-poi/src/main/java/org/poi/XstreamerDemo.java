package org.poi;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author nealin
 * @Date 2019/6/19 14:42
 * @Version 1.0
 * 使用Excel Streaming Reader进行海量数据读取
 */
public class XstreamerDemo {
    private FileInputStream inputStream;
    private Workbook workbook;

    public List<List<String>> read(String filePath) throws FileNotFoundException {
        inputStream = new FileInputStream(new File(filePath));
        workbook = StreamingReader.builder()
                .rowCacheSize(100)
                .bufferSize(4098)
                .open(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        List<List<String>> datas = new ArrayList<>();
        for (Row row : sheet) {
            List<String> rowData = new ArrayList<>(60);
            for (int i = 0; i < row.getLastCellNum(); i++) {
                String value = getValue(row.getCell(i));
                rowData.add(value);
            }
            datas.add(rowData);
        }
        return datas;
    }

    private String getValue(Cell xCell) {
        if (xCell == null) {
            return "";
        }
        if (xCell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xCell.getBooleanCellValue());
        } else if (xCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            return Double.valueOf(xCell.getNumericCellValue()).longValue() + "";
        } else if (xCell.getCellType() == Cell.CELL_TYPE_STRING) {
            return xCell.getStringCellValue();
        } else {
            return "";
        }
    }
}
