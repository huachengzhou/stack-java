package ce.blue;

import java.io.IOException;

public class ProcessDemo {
    public static void main(String[] args) {
        String path = "D:\\CS\\jacob-util\\run.bat";
        StringBuilder cmd = new StringBuilder();
        StringBuilder run = new StringBuilder() ;
        run.append("@echo off").append("\r");
        run.append("cd /d %~dp0").append("\r");
        run.append("start jre\\bin\\javaw.exe -jar -Xms256m -Xmx512m jacob-util-1.jar D:\\temp\\结果报告2021年01月26日.doc D:\\temp\\结果报告2021年01月26日V2.doc").append("\r");
        cmd.append("cmd.exe /k start ") ;
//        cmd.append(run.toString()) ;
        cmd.append(path) ;
        try {
            Process p = Runtime.getRuntime().exec(cmd.toString());
            if (p != null) {
                p.destroy();
                p = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
