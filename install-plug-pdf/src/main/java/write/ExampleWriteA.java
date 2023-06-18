package write;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.util.UUID;

/**
 * @Author zch
 * @Description
 * @createDate 2018/10/13
 **/
public class ExampleWriteA {
    private final String path = "E:\\doc\\pdf\\" ;

    /**
     * @Description:pdf 第一个例子
     * @Author:zch
     * @CreateDate:12:55 2018/10/13
     * @Version:1.0
     */
    @Test
    public void testA() throws Exception {
        //Step 1—Create a Document.
        Document document = new Document();
        //Step 2—Get a PdfWriter instance.
        PdfWriter.getInstance(document, new FileOutputStream(String.format("%s%s%s",path,"createSamplePDF",".pdf")));
        //Step 3—Open the Document.
        document.open();
        //Step 4—Add content.
        document.add(new Paragraph("Hello World"));
        //Step 5—Close the Document.
        document.close();
    }

    /**
     * @Description:给PDF文件设置文件属性
     * @Author:zch
     * @CreateDate:13:16 2018/10/13
     * @Version:1.0
     */
    @Test
    public void testB(){
        /*这个例子将展示如何给PDF文件设置各种属性，如作者名字，创建日期，创建者，或者标题。*/
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(String.format("%s%s%s",path, UUID.randomUUID().toString().substring(1,6),".pdf")));
            document.open();
            document.add(new Paragraph("表示一个缩进的文本段落，在段落中，你可以设置对齐方式，缩进，段落前后间隔等。")) ;
            ////Set attributes here
            document.addCreationDate();//创建日期i
            document.addAuthor("blake");//作者名字
            document.addCreator("blake.zhou");//作者
            document.addTitle("标题X");
            document.addSubject("主题V");
            document.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    * https://www.cnblogs.com/chenpi/p/5534595.html#_label4
    * https://www.cnblogs.com/liaojie970/p/7132475.html
    * https://blog.csdn.net/sinat_29957455/article/details/68951228
    * */
}
