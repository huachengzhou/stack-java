package org.word;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.FileUtils;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

/**
 * @Author noatnu
 * @Description
 * @createDate 2019/6/16
 **/
public class DemoA {
    private static Map<String, String> map = new HashMap<String, String>();

    static  {
        map.put("${title}", "POI word export");
        map.put("${second}", "2");
        map.put("${name}", "seawater");
        map.put("${tel}", "0000-0000");
        map.put("${remark}", "remark info");
        map.put("${test}", StringUtils.repeat("["+ RandomStringUtils.random(25)+"    \r"+RandomStringUtils.random(5)+"]",100));
    }

    private final String path = FileUtils.getMainDataDir(this.getClass(), "");

    private void initWord(String path)throws Exception {
        XWPFDocument document = new XWPFDocument();
        map.forEach((key, value) -> {
            XWPFParagraph xwpfParagraph = document.createParagraph();
            xwpfParagraph.createRun().setText(key);
        });
        document.write(new FileOutputStream(path));
    }

    @Test
    public void test1() throws Exception {
        String dir = String.format("%s%s.docx",path,"hello") ;
        initWord(dir);
        processParagraph2(dir,map);
    }

    private void processParagraph2(String srcPath, Map<String, String> map) {
        try {
            XWPFDocument document = new XWPFDocument(new FileInputStream(srcPath));
            /**
             * 替换段落中的指定文字
             */
            Iterator<XWPFParagraph> itPara = document.getParagraphsIterator();
            while (itPara.hasNext()) {
                XWPFParagraph paragraph = itPara.next();
                Set<String> set = map.keySet();
                Iterator<String> iterator = set.iterator();
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    List<XWPFRun> run = paragraph.getRuns();
                    for (int i = 0; i < run.size(); i++) {
                        if (run.get(i).getText(run.get(i).getTextPosition()) != null &&
                                run.get(i).getText(run.get(i).getTextPosition()).equals(key)) {
                            /**
                             * 参数0表示生成的文字是要从哪一个地方开始放置,设置文字从位置0开始
                             * 就可以把原来的文字全部替换掉了
                             */
                            if (StringUtils.isNotEmpty(map.get(key))) {
                                run.get(i).setText(map.get(key), 0);
                            }
                        }
                    }
                }
            }

            document.write(new FileOutputStream(srcPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
