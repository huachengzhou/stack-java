package org.table;

import org.FileUtils;
import org.HwpfUtils;
import org.PoiUtils;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

/**
 * @Author noatnu
 * @Description
 * @createDate 2019/5/21
 **/
public class Demo1 {

    @Test
    public void readmeA() throws IOException {
        String path = FileUtils.getMainDataDir(this.getClass(), "");
        path = String.format("%s%s", path, "成都中心城区基准地价-成果简本.doc");
        PoiUtils poiUtils = new PoiUtils();

        List<Table> tableList = HwpfUtils.getWordHwpfTable(path);
        for (Table table : tableList) {
            List<TableRow> tableRowList = HwpfUtils.getWordHwpfRow(table);
            for (TableRow tableRow : tableRowList) {

            }
        }

    }

}
