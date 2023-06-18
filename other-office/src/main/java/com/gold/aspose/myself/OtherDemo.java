package com.gold.aspose.myself;

import com.aspose.words.*;
import com.gold.aspose.AsposeUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @Author noatnu
 * @Description
 * @createDate 2019/6/8
 **/
public class OtherDemo {

    /**
     * 使用Aspose.words 把一个文档中的Section完整拷贝到另..._CSDN论坛
     * @throws Exception
     */
    @Test
    public void test1()throws Exception{
        String strFile = "" ;
        Document originalDoc = new Document(strFile);

        String strCurrentPath = "" ;
        //
        int sectCount = originalDoc.getSections().getCount();

        for (int sectIndex = 0; sectIndex < sectCount; sectIndex++)
        {
            Document mainDoc = new Document();
            mainDoc.getFirstSection().getBody().removeAllChildren();
            //NodeImporter importer = new NodeImporter(originalDoc, mainDoc, ImportFormatMode.KeepSourceFormatting);
            Section srcSection = originalDoc.getSections().get(sectIndex) ;
            //Node dstSection = originalDoc.ImportNode(srcSection, true, ImportFormatMode.KeepSourceFormatting);
            //mainDoc.AppendChild(dstSection);
            int nodeCount = srcSection.getBody().getChildNodes().getCount();
            NodeImporter importer = new NodeImporter(originalDoc, mainDoc, ImportFormatMode.KEEP_SOURCE_FORMATTING);
            for (int nodeIndex = 0; nodeIndex < nodeCount; nodeIndex++)
            {
                Node srcNode = srcSection.getBody().getChildNodes().get(nodeIndex) ;
                Node newNode = importer.importNode(srcNode,true) ;
                mainDoc.getFirstSection().getBody().appendChild(newNode) ;
            }
            mainDoc.save("" ,SaveFormat.DOCX) ;
        }
    }

    /**
     * 必要的，验证码校验
     */
    @BeforeTest
    public void before() {
        AsposeUtils.checkLicense();
    }

}
