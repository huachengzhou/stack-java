package write;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class TransFormDemo {


    //pdf转word
    @Test
    public void testA() throws Exception{
        String pdfFile = "D:\\data\\保险公司偿付能力监管规则第2号.pdf";
        PDDocument doc = PDDocument.load(new File(pdfFile));
        int pagenumber = doc.getNumberOfPages();
        pdfFile = pdfFile.substring(0, pdfFile.lastIndexOf("."));
        String fileName = pdfFile + ".doc";
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(fileName);
        Writer writer = new OutputStreamWriter(fos, "UTF-8");
        PDFTextStripper stripper = new PDFTextStripper();
        stripper.setSortByPosition(true);// 排序
        stripper.setStartPage(1);// 设置转换的开始页
        stripper.setEndPage(pagenumber);// 设置转换的结束页
        stripper.writeText(doc, writer);
        writer.close();
        doc.close();
        System.out.println("pdf转换word成功！");
    }

}
