package com.gold.jac;


import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class WordBean {
    // word文档
    private Dispatch doc;
    // word运行程序对象
    private ActiveXComponent word;
    // 所有word文档集合
    private Dispatch documents;
    // 选定的范围或插入点
    private Dispatch selection;
    private boolean saveOnExit = true;

    /**
     * @param visible true表示word应用程序可见
     */
    public WordBean(boolean visible) {
        // TODO Auto-generated constructor stub
        if (word == null) {
            word = new ActiveXComponent("Word.Application");
            word.setProperty("Visible", new Variant(visible));
        }
        if (documents == null)
            documents = word.getProperty("Documents").toDispatch();
    }

    /**
     * 创建一个新的word文档
     */
    public void createNewDocument() {
        doc = Dispatch.call(documents, "Add").toDispatch();
        selection = Dispatch.get(word, "Selection").toDispatch();
    }

    /**
     * 打开一个已存在的文档
     *
     * @param docPath
     */
    public void openDocument(String docPath) {
        closeDocument();
        doc = Dispatch.call(documents, "Open", docPath).toDispatch();
        selection = Dispatch.get(word, "Selection").toDispatch();
    }

    /**
     * 把选定的内容或插入点向上移动
     *
     * @param pos 移动的距离
     */
    public void moveUp(int pos) {
        if (selection == null)
            selection = Dispatch.get(word, "Selection").toDispatch();
        for (int i = 0; i < pos; i++)
            Dispatch.call(selection, "MoveUp");
    }

    /**
     * 把选定的内容或者插入点向下移动
     *
     * @param pos 移动的距离
     */
    public void moveDown(int pos) {
        if (selection == null)
            selection = Dispatch.get(word, "Selection").toDispatch();
        for (int i = 0; i < pos; i++)
            Dispatch.call(selection, "MoveDown");
    }

    /**
     * 把选定的内容或者插入点向左移动
     *
     * @param pos 移动的距离
     */
    public void moveLeft(int pos) {
        if (selection == null)
            selection = Dispatch.get(word, "Selection").toDispatch();
        for (int i = 0; i < pos; i++) {
            Dispatch.call(selection, "MoveLeft");
        }
    }

    /**
     * 把选定的内容或者插入点向右移动
     *
     * @param pos 移动的距离
     */
    public void moveRight(int pos) {
        if (selection == null)
            selection = Dispatch.get(word, "Selection").toDispatch();
        for (int i = 0; i < pos; i++)
            Dispatch.call(selection, "MoveRight");
    }

    /**
     * 把插入点移动到文件首位置
     */
    public void moveStart() {
        if (selection == null)
            selection = Dispatch.get(word, "Selection").toDispatch();
        Dispatch.call(selection, "HomeKey", new Variant(6));
    }

    public void moveEnd() {
        if (selection == null)
            selection = Dispatch.get(word, "Selection").toDispatch();
        Dispatch.call(selection, "EndKey", new Variant(6));
    }

    /**
     * 向 document 中插入文本内容
     *
     * @param textToInsert 插入的文本内容
     */
    public void insertText(String textToInsert) {
        // 在指定的位置插入文本内容
        Dispatch.put(selection, "Text", textToInsert);
        // 取消选中,应该就是移动光标
        Dispatch format = Dispatch.get(selection, "ParagraphFormat").toDispatch();
        // 设置段落格式为首行缩进2个字符
        Dispatch.put(format, "CharacterUnitFirstLineIndent", new Variant(2));
        Dispatch.call(selection, "MoveRight", new Variant(1), new Variant(1));
        //moveRight(1);
        Dispatch.call(selection, "TypeParagraph");// 插入一个空行
        //Dispatch.call(selection, "MoveUp");
        //moveDown(1);
    }

    /**
     * 插入标题
     *
     * @param num   标题编号
     * @param level 标题级别：-2：一级标题；-3：二级标题；-4：三级标题；-5：四级标题
     * @param text  标题题目
     */
    public void insertTitle(String num, int level, String text) {
        Dispatch activeDocument = Dispatch.get(word, "ActiveDocument").toDispatch();

        //Dispatch.call(selection, "TypeParagraph");// 插入一个空行
        //moveDown(1);
        Dispatch.put(selection, "Text", num + " " + text);
        Dispatch style = Dispatch.call(activeDocument, "Styles", new Variant(level)).toDispatch();
        ;
        Dispatch.put(selection, "Style", style);
        moveRight(1);
        Dispatch.call(selection, "TypeParagraph");// 插入一个空行
        //moveDown(1);
    }

    /**
     * 创建目录
     */
    public void createCatalog() {
        Dispatch activeDocument = Dispatch.get(word, "ActiveDocument").toDispatch();

        Dispatch.call(selection, "HomeKey", new Variant(6)); // 将光标移到文件首的位置
        Dispatch.call(selection, "TypeParagraph");// 插入一个空行
        moveUp(1);

        Dispatch.put(selection, "Text", "目录");
        Dispatch style = Dispatch.call(activeDocument, "Styles", new Variant(-2)).toDispatch();
        ;
        Dispatch.put(selection, "Style", style);
        Dispatch alignment = Dispatch.get(selection, "ParagraphFormat").toDispatch();// 段落格式
        Dispatch.put(alignment, "Alignment", "1"); // (1:置中 2:靠右 3:靠左)
        moveRight(1);
        Dispatch.call(selection, "TypeParagraph");// 插入一个空行

        Dispatch myRange = Dispatch.call(selection, "Range").toDispatch();

        /** 获取目录 */
        Dispatch tablesOfContents = Dispatch.get(activeDocument, "TablesOfContents").toDispatch();

        Dispatch add = Dispatch.call(tablesOfContents, "Add", myRange, new Variant(true),
                new Variant(1), new Variant(3), new Variant(true), new Variant(true), new Variant('T'),
                new Variant(true), new Variant(true), new Variant(1), new Variant(true)).toDispatch();

//        Dispatch.put(add, "RightAlignPageNumbers", new Variant(true));
//        Dispatch.put(add, "UseHeadingStyles", new Variant(true));
//        Dispatch.put(add, "UpperHeadingLevel", new Variant(1));
//        Dispatch.put(add, "LowerHeadingLevel", new Variant(3));
//        Dispatch.put(add, "IncludePageNumbers", new Variant(true));
//        Dispatch.put(add, "UseHyperlinks", new Variant(true));
//        Dispatch.put(add, "HidePageNumbersInWeb", new Variant(true));

//        Dispatch.call(add, "Add", myRange);

        //插入一个分页符
        Dispatch.call(selection, "InsertBreak", new Variant(7));
        Dispatch.call(selection, "TypeBackspace");
    }


    /**
     * 更新目录
     *
     * @param outputPath
     * @param doc
     */
    public void updateCatalog(String outputPath, Dispatch doc) {
        /** 打开word文档 */
        //Dispatch doc = Dispatch.invoke(documents, "Open", Dispatch.Method,
        //        new Object[] { outputPath, new Variant(false), new Variant(true) }, new int[1]).toDispatch();
        //Dispatch doc = Dispatch.call(documents, "Open", outputPath).toDispatch();

        Dispatch activeDocument = word.getProperty("ActiveDocument").toDispatch();
        /** 获取目录 */
        Dispatch tablesOfContents = Dispatch.get(activeDocument, "TablesOfContents").toDispatch();
        /** 获取第一个目录。若有多个目录，则传递对应的参数  */
        Variant tablesOfContent = Dispatch.call(tablesOfContents, "Item", new Variant(1));
        /** 更新目录，有两个方法：Update 更新域，UpdatePageNumbers 只更新页码 */
        Dispatch toc = tablesOfContent.toDispatch();
        toc.call(toc, "Update");

        /** 另存为 */
        Dispatch.call(Dispatch.call(word, "WordBasic").getDispatch(), "FileSaveAs", outputPath);
        //System.out.println("更新目录");
        /** 关闭word文档 */
        Dispatch.call(doc, "Close", new Variant(false));

        /** 退出word进程 */
        close();
    }

    /**
     * 在当前插入点插入图片
     *
     * @param imagePath 图片路径
     */
    public void insertImage(String imagePath, int c, int tc, String title) {
        Dispatch.call(Dispatch.get(selection, "InLineShapes").toDispatch(), "AddPicture", imagePath);

        Dispatch.call(selection, "TypeParagraph");// 插入一个空行
        Dispatch alignment = Dispatch.get(selection, "ParagraphFormat").toDispatch();// 段落格式
        Dispatch.put(alignment, "Alignment", "1"); // (1:置中 2:靠右 3:靠左)
        //moveRight(1);
        putText("图" + c + "-" + tc + " " + title);
        moveRight(1);
        Dispatch.call(selection, "TypeParagraph");// 插入一个空行
    }

    public void insertBlankRow() {
        Dispatch.call(selection, "TypeParagraph");// 插入一个空行
        Dispatch alignment = Dispatch.get(selection, "ParagraphFormat").toDispatch();// 段落格式
        Dispatch.put(alignment, "Alignment", "3"); // (1:置中 2:靠右 3:靠左)
    }

    /**
     * 创建表格
     *
     * @param cols 列数
     * @param rows 行数
     */
    public void createTable(int numCols, int numRows, int c, int tc, String title) {
//        Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
//        Dispatch range = Dispatch.get(selection, "Range").toDispatch();
//        Dispatch newTable = Dispatch.call(tables, "Add", range, new Variant(numRows), new Variant(numCols))
//                .toDispatch();
//        Dispatch.call(selection, "MoveRight");
//        moveEnd();

        Dispatch.call(selection, "TypeParagraph");// 插入一个空行
        Dispatch alignment = Dispatch.get(selection, "ParagraphFormat").toDispatch();// 段落格式
        Dispatch.put(alignment, "Alignment", "1"); // (1:置中 2:靠右 3:靠左)
        putText("表" + c + "-" + tc + " " + title);
        moveRight(1);
        Dispatch.call(selection, "TypeParagraph");// 插入一个空行

        Dispatch activeDocument = Dispatch.get(word, "ActiveDocument").toDispatch();
        Dispatch tables1 = Dispatch.get(activeDocument, "Tables").toDispatch();

        Dispatch range = Dispatch.get(selection, "Range").toDispatch();
        Dispatch.call(tables1, "Add", range, new Variant(numRows), new Variant(numCols), new Variant(1), new Variant(0)).toDispatch();

        Dispatch.call(selection, "MoveDown", new Variant(5), new Variant(numRows), new Variant(1));
        Dispatch format = Dispatch.get(selection, "ParagraphFormat").toDispatch();
        Dispatch.put(format, "Alignment", new Variant(1));

        moveLeft(1);
    }

    /**
     * 向选中的单元格中写入数据
     *
     * @param text
     */
    public void putText(String text) {
        Dispatch.put(selection, "Text", text);
    }

    /**
     * 增加一行
     *
     * @param tableIndex word文档中的第N张表(从1开始)
     */
    public void addRow(int tableIndex) {
        Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
        // 要填充的表格
        Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex)).toDispatch();
        // 表格的所有行
        Dispatch rows = Dispatch.get(table, "Rows").toDispatch();
        Dispatch.call(rows, "Add");
    }

    /**
     * 合并单元格
     *
     * @param tableIndex
     * @param fstCellRowIdx
     * @param fstCellColIdx
     * @param secCellRowIdx
     * @param secCellColIdx
     */
    public void mergeCell(int tableIndex, int fstCellRowIdx, int fstCellColIdx, int secCellRowIdx, int secCellColIdx) {
        // 所有表格
        Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
        // 要填充的表格
        Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex)).toDispatch();
        Dispatch fstCell = Dispatch.call(table, "Cell", new Variant(fstCellRowIdx), new Variant(fstCellColIdx))
                .toDispatch();
        Dispatch secCell = Dispatch.call(table, "Cell", new Variant(secCellRowIdx), new Variant(secCellColIdx))
                .toDispatch();
        Dispatch.call(fstCell, "Merge", secCell);
    }

    /**
     * 在指定的单元格里填写数据
     *
     * @param tableIndex
     * @param cellRowIdx
     * @param cellColIdx
     * @param txt
     */
    public void putTxtToCell(int tableIndex, int cellRowIdx, int cellColIdx, String txt) {
        // 所有表格
        Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
        // 要填充的表格
        Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex)).toDispatch();
        Dispatch cell = Dispatch.call(table, "Cell", new Variant(cellRowIdx), new Variant(cellColIdx)).toDispatch();
        Dispatch.call(cell, "Select");
        Dispatch.put(selection, "Text", txt);
    }

    /**
     * 增加一列
     *
     * @param tableIndex word文档中的第N张表(从1开始)
     */
    public void addCol(int tableIndex) {
        // 所有表格
        Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
        // 要填充的表格
        Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex)).toDispatch();
        // 表格的所有行
        Dispatch cols = Dispatch.get(table, "Columns").toDispatch();
        Dispatch.call(cols, "Add").toDispatch();
        Dispatch.call(cols, "AutoFit");
    }

    /**
     * 设置当前选定内容的字体
     *
     * @param boldSize
     * @param italicSize
     * @param underLineSize 下划线
     * @param colorSize     字体颜色
     * @param size          字体大小
     * @param name          字体名称
     */
    public void setFont(boolean bold, boolean italic, boolean underLine, String colorSize, String size, String name) {
        Dispatch font = Dispatch.get(selection, "Font").toDispatch();
        Dispatch.put(font, "Name", new Variant(name));
        Dispatch.put(font, "Bold", new Variant(bold));
        Dispatch.put(font, "Italic", new Variant(italic));
        Dispatch.put(font, "Underline", new Variant(underLine));
        Dispatch.put(font, "Color", colorSize);
        Dispatch.put(font, "Size", size);
    }

    /**
     * 文件保存或另存为
     *
     * @param savePath 保存或另存为路径
     */
    public void save(String savePath) {
        Dispatch.call((Dispatch) Dispatch.call(word, "WordBasic").getDispatch(), "FileSaveAs", savePath);
    }

    /**
     * 关闭当前word文档
     */
    public void closeDocument() {
        if (doc != null) {
            Dispatch.call(doc, "Save");
            Dispatch.call(doc, "Close", new Variant(saveOnExit));
            doc = null;
        }
    }

    /**
     * 关闭全部应用
     */
    public void close() {
        closeDocument();
        if (word != null) {
            Dispatch.call(word, "Quit");
            word = null;
        }
        selection = null;
        documents = null;
    }
}