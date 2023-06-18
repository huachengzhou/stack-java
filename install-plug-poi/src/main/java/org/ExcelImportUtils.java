package org;


import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.poi.ss.usermodel.*;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * excel 导入辅助类
 *
 * @author zch
 */
public final class ExcelImportUtils implements Serializable {


    /**
     * 导入excel表格,返回的List<Map<Integer, String>>数据结构.
     *
     * @param
     * @return 返回list集合
     * @throws Exception
     */
    public static List<Map<Integer, String>> read(InputStream is, String name) throws Exception {
        //最终返回数据
        List<Map<Integer, String>> list = new ArrayList<Map<Integer, String>>();
        Workbook workbook = null;
        // 创建excel操作对象
        if (name.contains(".xlsx") || name.contains(".xls")) {
            workbook = WorkbookFactory.create(is);
        }
        //得到一个工作表
        Sheet sheet = workbook.getSheetAt(0);
        //获得数据的总行数
        int totalRowNum = sheet.getLastRowNum();

        //获得总列数
        int cellLength = sheet.getRow(0).getPhysicalNumberOfCells();
        Map<Integer, String> map = null;
        //获得所有数据
        //从第x行开始获取
        for (int x = 0; x <= totalRowNum; x++) {
            map = new HashMap<Integer, String>();
            //获得第i行对象
            Row row = sheet.getRow(x);
            //如果一行里的所有单元格都为空则不放进list里面
            int a = 0;
            for (int y = 0; y < cellLength; y++) {
                if (!(row == null)) {
                    Cell cell = row.getCell(y);
                    if (cell == null) {
                        map.put(y, "");
                    } else {
                        map.put(y, PoiUtils.getCellValue(cell));
                    }
                    if (map.get(y) == null || "".equals(map.get(y))) {
                        a++;
                    }
                }
            }//for
            if (a != cellLength && row != null) {
                list.add(map);
            }
        }
        return list;
    }


    /**
     * 字符串 list 分组
     *
     * @param list
     * @param splitSize
     * @return
     */
    public static List<List<String>> splitsStringList(List<String> list, int splitSize) {
        return new SplitsList<String>().splitsList(list, splitSize);
    }

    public static List<List<Integer>> splitsIntegerList(List<Integer> list, int splitSize) {
        return new SplitsList<Integer>().splitsList(list, splitSize);
    }

    public static List<List<Long>> splitsLongList(List<Long> list, int splitSize) {
        return new SplitsList<Long>().splitsList(list, splitSize);
    }

    /**
     * 泛型 分组方法
     *
     * @param <T>
     */
    public static class SplitsList<T> {
        private T t;

        /**
         * 随机排序
         *
         * @param list
         * @return
         */
        public List<T> soft(List<T> list) {
            if (list == null || list.size() == 0) {
                return null;
            }
            int size = list.size();
            List<T> aList = new ArrayList<>(size);
            final int[] filterArr = new int[size];
            for (int i = 0; i < size; i++) {
                int index = 0;
                do {
                    index = RandomUtils.nextInt(0, size + 1);
                } while (ArrayUtils.contains(filterArr, index));
                //取得的索引减一是因为多加了1
                T o = list.get(index - 1);
                filterArr[i] = index;
                aList.add(o);
            }
            return aList;
        }

        /**
         * 分组
         *
         * @param list
         * @param splitSize
         * @return
         */
        public List<List<T>> splitsList(List<T> list, int splitSize) {
            if (null == list) {
                return null;
            }
            int listSize = list.size();
            List<List<T>> newList = new ArrayList<>();
            if (listSize < splitSize) {
                newList.add(list);
                return newList;
            }
            int addLength = splitSize;
            int times = listSize / splitSize;
            if (listSize % splitSize != 0) {
                times += 1;
            }
            int start = 0;
            int end = 0;
            int last = times - 1;
            for (int i = 0; i < times; i++) {
                start = i * splitSize;
                if (i < last) {
                    end = start + addLength;
                } else {
                    end = listSize;
                }
                newList.add(list.subList(start, end));
            }
            return newList;
        }

        public T getT() {
            return t;
        }
    }


}