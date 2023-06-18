package com.gold.aspose.example;

import com.aspose.words.*;
import com.gold.aspose.AsposeDataHelp;
import com.gold.aspose.AsposeUtils;
import com.gold.aspose.FileUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * @Author noatnu
 * @Description
 * @createDate 2019/6/2
 **/
public class AsposeInsertBarcodeOnEachPage {
    private String dataPath = FileUtils.getMainDataDir(this.getClass(),"")+"data\\" ;
    /**
     *  每页插入条形码
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        // Create a blank document.
        Document doc = new Document();
        DocumentBuilder builder = new DocumentBuilder(doc);

        // The number of pages the document should have.
        int numPages = 4;
        // The document starts with one section, insert the barcode into this
        // existing section.
        insertBarcodeIntoFooter(builder, doc.getFirstSection(), 1, HeaderFooterType.FOOTER_PRIMARY);

        int i = 1;
        while (i < numPages)
        {
            // Clone the first section and add it into the end of the document.
            Section cloneSection = (Section) doc.getFirstSection().deepClone(false);
            cloneSection.getPageSetup().setSectionStart(SectionStart.NEW_PAGE);
            doc.appendChild(cloneSection);

            // Insert the barcode and other information into the footer of the
            // section.
            insertBarcodeIntoFooter(builder, cloneSection, i, HeaderFooterType.FOOTER_PRIMARY);
            i += 1;
        }

        // Save the document as a PDF to disk. You can also save this directly
        // to a stream.
        doc.save(AsposeDataHelp.getPath(), SaveFormat.DOCX);
        System.out.println("Aspose Barcode Inserted...");
    }

    private void insertBarcodeIntoFooter(DocumentBuilder builder, Section section,
                                         int pageId, int footerType) throws Exception {
        // Move to the footer type in the specific section.
        builder.moveToSection(section.getDocument().indexOf(section));
        builder.moveToHeaderFooter(footerType);

        // Insert the barcode, then move to the next line and insert the ID
        // along with the page number.
        // Use pageId if you need to insert a different barcode on each page. 0
        // = First page, 1 = Second page etc.
        builder.insertImage(ImageIO.read(new File(dataPath + "barcode.png")));
        builder.writeln();
        builder.write("1234567890");
        builder.insertField("PAGE");

        // Create a right aligned tab at the right margin.
        double tabPos = section.getPageSetup().getPageWidth()
                - section.getPageSetup().getRightMargin() - section.getPageSetup().getLeftMargin();
        builder.getCurrentParagraph().getParagraphFormat().getTabStops()
                .add(new TabStop(tabPos, TabAlignment.RIGHT, TabLeader.NONE));

        // Move to the right hand side of the page and insert the page and page
        // total.
        builder.write(ControlChar.TAB);
        builder.insertField("PAGE");
        builder.write(" of ");
        builder.insertField("NUMPAGES");
    }

    /**
     * 必要的，验证码校验
     */
    @BeforeTest
    public void before(){
        AsposeUtils.checkLicense();
    }

}
