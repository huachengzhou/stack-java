package org.poi;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        long t1=System.currentTimeMillis();
        XstreamerDemo readDemo=new XstreamerDemo();
        List<List<String>> data = readDemo.read("E:\\满意度.xlsx");
        long t2=System.currentTimeMillis();
        SxssfDemo sxssfDemo =new SxssfDemo();
        sxssfDemo.write("E:\\da.xlsx",data);
        long t3=System.currentTimeMillis();
        System.out.println("数据行："+data.size()+"数据列"+data.get(0).size());
        System.out.println("读用时："+(t2-t1)+"ms");
        System.out.println("写用时："+(t3-t2)+"ms");
        System.out.println("success");
    }
}
