package com.gold.tree;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.xerces.impl.Constants;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreemarkerCreateWord {

    public static void main(String[] args) {
        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        configuration.setDefaultEncoding("UTF-8");
        Map<String, Object> dataMap = getData();

        configuration.setClassForTemplateLoading(FreemarkerCreateWord.class, "/");

        try {
            //获取模板文件
            Template t = configuration.getTemplate("temp.xml");
            //导出文件
            File outFile = new File("D:/test/outFile" + Math.random() * 10000 + ".docx");
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
            //将填充数据填入模板文件并输出到目标文件
            t.process(dataMap, out);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Map<String, Object> getData() {
        Map<String, Object> dataMap = new HashMap<>(8);
        dataMap.put("tradeConfirmId", "123456");
        dataMap.put("counterPartyName", "今天是个好日子");
        return dataMap;
    }
    /**
     * 该方法用来生成word文件
     * createWordFile用来组装业务，包括读取xml数据生成word，并返回给调用出的结果
     *
     * @param:父级文件夹名称
     * @param:需要处理的文件所在目录
     */
    public boolean createWordFile(String parentFileName, String newFilePath) throws Exception {
        String errorInfo = "" ;
        boolean result = false;
        File xmlFile = new File(newFilePath + File.separator + "200105.xml");
        if (xmlFile.isFile() && xmlFile.exists()) {//是文件且存在
            List list = readWord(xmlFile);//组装数据、以及文件名称
            if (list != null && list.size() > 0) {
                String wordName = list.get(0).toString();//文件名称
                Map dataMap = (Map) list.get(1);//集合数据
                String templateFilePath = new File("").getAbsolutePath() + File.separator + "config";//设定为当前文件夹
//              System.out.println("模板文件所在目录："+templateFilePath);
                boolean flag = createWord(dataMap, templateFilePath, "word.ftl", "asgahas", wordName + ".doc");//生成word
                if (flag) {
                    result = true;
                } else {
                    errorInfo = "word文件生成失败!";
                }
            } else {
                errorInfo = "无法读取" + (newFilePath + File.separator + "200105.xml") + "文件中的数据信息!";
            }
        }
        return result;
    }

    /***
     * 该方法用来组装数据
     * @param xmlFile：需要进行解析的xml文件
     * */
    public List readWord(File xmlFile) {
        /** 用于组装word页面需要的数据 */
        Map<String, Object> dataMap = new HashMap<String, Object>();
        List list = null;
        StringBuffer wordName = new StringBuffer();//word文档名称：案件编号+名称+内部编号
        try {
            //读取XML
            SAXReader sax = getSAXReader();
            Document doc = sax.read(xmlFile);//读取文档
            String fileContent = "", appAJ = "";
            //1、案件编号
            Node node = doc.selectSingleNode("//ANJIANBH");
            if (node != null) {
                fileContent = node.getText().trim();
            } else {
                fileContent = "";
            }
            wordName.append(fileContent);
            dataMap.put("caseNum", fileContent);//案件编号

            //2、名称
            node = doc.selectSingleNode("//FAMINGCZMC");
            if (node != null) {
                fileContent = node.getText().trim();
            } else {
                fileContent = "";
            }
            wordName.append(escapeExprSpecialWord(fileContent));//去除特殊字符
            dataMap.put("name", fileContent);//名称

            //3、内部编号/申请号
            fileContent = "内部编号：";
            node = doc.selectSingleNode("//NEIBUBH");
            if (node != null) {//说明没有内部编号
                fileContent = "内部编号：" + node.getText().trim();
                appAJ = node.getText().trim();
                if (appAJ.toUpperCase().startsWith("AJ")) {//避免出现小写aj的情况，所以全部转成大写进行比较
                    //内部编号用最后一个下划线截取
                    appAJ = appAJ.substring(appAJ.lastIndexOf("_") + 1);
                }
                wordName.append(appAJ);
            } else {//那么查找是否有申请号
                node = doc.selectSingleNode("//SHENQINGH");
                if (node != null) {
                    fileContent = node.getText().trim();
                    wordName.append(fileContent.split("：")[1]);
                }
            }
            dataMap.put("num", fileContent);

            //4、提交人姓名或名称
            node = doc.selectSingleNode("//XINGMINGHMC");
            if (node != null) {
                fileContent = node.getText().trim();
            } else {
                fileContent = "";
            }
            dataMap.put("proxy", fileContent);
            //5、 收到时间
            node = doc.selectSingleNode("//QIANMINGSJC");
            if (node != null) {
                fileContent = node.getText().trim();
            } else {
                fileContent = "";
            }
            dataMap.put("time", fileContent);//收到时间

            //6、收到文件情况
            StringBuffer content = new StringBuffer();
            Element element = null;
            List<Map<String, Object>> fileList = new ArrayList<Map<String, Object>>();

            List<Element> els = doc.selectNodes("//SHOUDAOWJ");
            if (els != null && els.size() > 0) {
                for (int i = 0; i < els.size(); i++) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    element = els.get(i);
                    content.delete(0, content.length());//清空
                    content.append((i + 1) + "、");//序号
                    node = element.selectSingleNode(".//WENJIANMC");//文件名称
                    content.append(node.getText().trim() + "          ");
                    node = element.selectSingleNode(".//WENJIANGS");//文件格式
                    content.append(node.getText().trim() + "格式    ");
                    node = element.selectSingleNode(".//WENJIANDX");//文件大小
                    content.append("文件大小" + node.getText().trim());
//                  System.out.println(content.toString());
                    map.put("content", content.toString());
                    fileList.add(map);
                }
            } else {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("content", "");
                fileList.add(map);
            }
            dataMap.put("fileList", fileList);
            // 落款时间
            node = doc.selectSingleNode("//SHOUDAOSJ");
            if (node != null) {
                fileContent = node.getText().trim();
            } else {
                fileContent = "";
            }
            dataMap.put("date", fileContent);//落款时间
            list = new ArrayList();
            list.add(wordName);
            list.add(dataMap);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    /**
     * 该方法用来获取SXAReader对象
     */
    public SAXReader getSAXReader() {
        SAXReader saxReader = new SAXReader();
        /* 在读取文件时，去掉dtd的验证，可以缩短运行时间  */
        try {
//      saxReader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);//可能需要网络，所以不用它
            saxReader.setFeature(Constants.XERCES_FEATURE_PREFIX + Constants.LOAD_EXTERNAL_DTD_FEATURE, false);  //设置不需要校验头文件
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return saxReader;
    }

    /**
     * 转义正则特殊字符 （$()*+.[]?\^{},|/\:?"<>）
     *
     * @param keyword
     * @return
     */
    public String escapeExprSpecialWord(String keyword) {
        if (keyword != null && keyword.trim().length() > 0) {
            String[] fbsArr = {"/", "\\", ":", "*", "?", "\"", "<", ">", "|", "(", ")", "+", "[", "]", "^", "{", "}", "、"};
            for (String key : fbsArr) {
                if (keyword.contains(key)) {
                    keyword = keyword.replace(key, "");
                }
            }
        }
        return keyword;
    }

    /**
     * 该方法用来生成word文件
     *
     * @param dataMap:数据集合
     * @param templateFilePath:模板文件所在目录
     * @param templateFileName:模板文件名称
     * @param docFilePath:生成的doc文件保存路径
     * @param docFileName:生成的doc文件名称:名称+.doc
     */
    public static boolean createWord(Map dataMap,
                                     String templateFilePath, String templateFileName,
                                     String docFilePath, String docFileName) {
        try {
            Configuration configuration = new Configuration();//创建配置实例
            configuration.setDefaultEncoding("UTF-8");//设置编码
            configuration.setDirectoryForTemplateLoading(new File(templateFilePath));//加载模板文件
            Template template = configuration.getTemplate(templateFileName);//获取模板
            if (docFileName == null || !docFileName.toUpperCase().endsWith(".DOC")) {//为空或者不是以doc结尾的，添加后缀名
                docFileName = docFileName + ".doc";
            }
            File outFile = new File(docFilePath + File.separator + docFileName);
            //如果输出目标文件夹不存在，则创建
            if (!outFile.getParentFile().exists()) {
                outFile.getParentFile().mkdirs();
            }
            //将模板和数据模型合并生成文件
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
            //生成文件
            template.process(dataMap, out);
            //关闭流
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
