package ce.blue;

import com.general.SwingBootstrap;


public class DemoA {
    public static void test1() {
        String docfile = "D:\\temp\\结果报告2021年01月26日.doc";
        String toFile = "D:\\temp\\结果报告2021年01月26日V_v.doc";
        SwingBootstrap.run(docfile,toFile);
    }

    public static void main(String[] args) {
        test1() ;
    }
}
