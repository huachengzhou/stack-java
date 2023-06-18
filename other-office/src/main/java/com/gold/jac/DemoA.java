package com.gold.jac;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import java.io.File;

public class DemoA {

    public static void test1() {
        String docfile = "D:\\temp\\结果报告2021年01月26日.doc";
        String toFile = "D:\\temp\\结果报告2021年01月26日Vu1.doc";
        /**启动word进程*/
        ActiveXComponent app = new ActiveXComponent("Word.Application");

        app.setProperty("Visible", new Variant(false));
        Dispatch docs = app.getProperty("Documents").toDispatch();

/**打开word文档*/
        Dispatch doc = Dispatch.invoke(docs, "Open", Dispatch.Method, new Object[]{docfile, new Variant(false),
                new Variant(true)}, new int[1]).toDispatch();

        Dispatch activeDocument = app.getProperty("ActiveDocument").toDispatch();

/**获取目录*/
        Dispatch tablesOfContents = Dispatch.get(activeDocument, "TablesOfContents").toDispatch();

/**获取第一个目录。若有多个目录，则传递对应的参数*/
        Variant tablesOfContent = Dispatch.call(tablesOfContents, "Item", new Variant(1));

/**更新目录，有两个方法：Update　更新域，UpdatePageNumbers　只更新页码*/
        Dispatch toc = tablesOfContent.toDispatch();
        toc.call(toc, "UpdatePageNumbers");

/**另存为*/
        Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[]{
                toFile, new Variant()}, new int[1]);

/**关闭word文档*/
        Dispatch.call(doc, "Close", new Variant(false));

/**退出word进程*/
        app.invoke("Quit", new Variant[]{});
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test2() {
        System.out.println("java.library.path:"+System.getProperty("java.library.path"));
        System.out.println(System.getProperty("java.library.path"));
        System.loadLibrary("jacob-1.20-x86.dll");
        System.loadLibrary("jacob-1.20-x64.dll");
//         Dispatch.call(documents, "Open", docPath).toDispatch();
    }
}
