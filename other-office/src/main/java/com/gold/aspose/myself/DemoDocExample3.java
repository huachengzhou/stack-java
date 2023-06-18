package com.gold.aspose.myself;

import com.aspose.words.*;
import com.gold.aspose.AsposeDataHelp;
import com.gold.aspose.AsposeUtils;
import com.gold.aspose.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.regex.Pattern;

/**
 * Created by zch on 2019/8/9.
 */
public class DemoDocExample3 {

    @org.testng.annotations.Test
    public void handleReportCover()throws Exception{
        String path = new File(FileUtils.getMainDataDir(this.getClass(),"")).getParent();
        path += "\\example\\data\\document.doc" ;
        Document doc = new Document(path);
        DocumentBuilder documentBuilder = new DocumentBuilder(doc);
        String key = RandomStringUtils.randomNumeric(45) ;
        key = "" ;
        documentBuilder.writeln();
        documentBuilder.write(key);
        documentBuilder.insertBreak(BreakType.PAGE_BREAK);
        String replacePath = getDocument();
        doc.getRange().replace(Pattern.compile(key),new IReplacingCallback() {
            @Override
            public int replacing(ReplacingArgs e) throws Exception {
                DocumentBuilder builder = new DocumentBuilder((Document)e.getMatchNode().getDocument());
                builder.moveTo(e.getMatchNode());
                Document document = new Document(replacePath);
                builder.insertDocument(document, 0);
                return 0;
            }
        },false) ;
        doc.save(AsposeDataHelp.getPath(), SaveFormat.DOCX);
    }

    private String getDocument()throws Exception{
        Document document = new Document() ;
        DocumentBuilder documentBuilder = new DocumentBuilder(document);
        documentBuilder.writeln(StringUtils.repeat(RandomStringUtils.random(22),12));
        String replacePath = AsposeDataHelp.getPath() ;
        document.save(replacePath,SaveFormat.DOCX) ;
        return replacePath ;
    }


    /**
     * 必要的，验证码校验
     */
    @BeforeTest
    public void before() {
        AsposeUtils.checkLicense();
    }

}
