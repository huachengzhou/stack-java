package com.general;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;


public class SwingBootstrap {


    private static final Logger LOGGER = LoggerFactory.getLogger(SwingBootstrap.class);

    //传入的args 为目录 ,java -jar demo.jar JOURNAL_TREENODE_DATA-20190404174502.txt processType=1
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            return;
        }
        String docfile = args[0];
        String toFile = args[1];

        System.out.println(docfile);
        System.out.println(toFile);
        System.out.println(System.currentTimeMillis());
        System.getProperty("java.library.path");
        System.out.println(System.currentTimeMillis());
        //1:检查参数是否为文件
        File file = new File(docfile);
        if (!file.isFile()) {
            return;
        }


        try {
            run(docfile, toFile);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            LOGGER.info("处理失败");
        }
    }

    public static void run(String docfile, String toFile) {
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
}
