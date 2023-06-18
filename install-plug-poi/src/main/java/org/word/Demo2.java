package org.word;

import org.AsposeUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.FileUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author noatnu
 * @Description
 * @createDate 2019/6/16
 **/
public class Demo2 {
    private static Map<String, String> map = new HashMap<String, String>();

    private final String path = FileUtils.getMainDataDir(this.getClass(), "");
    static  {
        map.put("${title}", "POI word export");
        map.put("${second}", "2");
        map.put("${name}", "seawater");
        map.put("${tel}", "0000-0000");
        map.put("${remark}", "remark info");
        map.put("${test}", StringUtils.repeat("["+RandomStringUtils.random(25)+"    \r"+RandomStringUtils.random(5)+"]",100));
    }

    @Test
    public void test1() throws Exception {
        String dir = String.format("%s%s.doc",path,"hello") ;
        initWord(dir);
        replaceText(dir,map);
    }

    /**
     * 由于doc apache HWPFDocument 无法创建word所以使用其它
     * @param path
     * @throws Exception
     */
    private void initWord(String path)throws Exception{

        {
            com.aspose.words.Document doc = new com.aspose.words.Document();
            com.aspose.words.DocumentBuilder builder = new com.aspose.words.DocumentBuilder(doc);
            builder.insertParagraph();
            map.forEach((key, value) -> {
                try {
                    builder.writeln(key);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            doc.save(path, com.aspose.words.SaveFormat.DOC) ;
        }
        File file = new File(path);
        //判断文件是否已存在
        if (!file.exists()){
            file.createNewFile();
        }
    }

    public void  replaceText(String path,Map<String, String> map)throws Exception{
        HWPFDocument hwpfDocument = new HWPFDocument(new FileInputStream(path)) ;
        Range range = hwpfDocument.getRange();
        int i = 0;
        for (Map.Entry<String,String> entry:map.entrySet()){
            if (StringUtils.contains(range.text(),entry.getKey())){
                i++;
                range.replaceText(entry.getKey(),entry.getValue());
            }
        }
        if (i != 0){
            hwpfDocument.write(new FileOutputStream(path));
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
