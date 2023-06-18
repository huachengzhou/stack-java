package com.gold.aspose;

import com.google.common.base.Objects;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author zch
 * @Description
 * @createDate 2019/6/2
 **/
public class AsposeDataHelp {

    private static final StringBuffer stringBuffer = new StringBuffer(8);

    public static String getPath() {
        return getPath("docx");
    }

    /**
     * 获取后缀并且不重复的文件,会删除当天以外的文件夹
     * @param suffix
     * @return
     */
    public static String getPath(String suffix) {
        stringBuffer.delete(0, stringBuffer.length());
        String timePath = DateUtils.format(new Date(), DateUtils.DATE_PATTERN);
        String data = "data\\" ;
        String path = FileUtils.getMainDataDir(AsposeDataHelp.class, data + timePath);
        File source = new File(path);
        if (source.isDirectory()){
            File file = getFileParent(timePath, source);
            if (file.isDirectory()){
                List<File> fileList = Arrays.asList(file.listFiles());
                for (File f:fileList){
                    if (!Objects.equal(timePath,StringUtils.substringAfterLast(f.getPath(),data))){
                        FileUtils.deleteDir(f) ;
                    }
                }
            }
        }
        stringBuffer.append(path);
        stringBuffer.append(RandomStringUtils.randomAlphabetic(8));
        stringBuffer.append(".").append(suffix);
        return stringBuffer.toString();
    }

    /**
     * 获取需要的目标文件
     * @param path
     * @param file
     * @return
     */
    private static File getFileParent(String path, File file) {
        String name = StringUtils.substringAfterLast(file.getPath(), path);
        if (Objects.equal("", name)) {
            return file.getParentFile();
        } else {
            return getFileParent(path, file.getParentFile());
        }
    }


}
