package org;

import org.DateUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 描述:普通文件操作类
 *
 * @author:zch
 * @data: 2017/8/11
 * @time: 14:37
 */
public class FileUtils {

    /**
     * Demo3Table.class demo3table
     *
     * @param c
     * @param polymerize
     * @return
     */
    public static String getTestDataDirAddClassPath(Class<?> c, String polymerize) {
        File dir = new File(System.getProperty("user.dir"));
        StringBuilder builder = new StringBuilder(128);
        if (StringUtils.isNotBlank(polymerize)) {
            builder.append(dir.toString()).append(File.separator).append(polymerize).append("\\").append("src").append("\\test\\java\\");
        } else {
            builder.append(dir.toString()).append(File.separator).append("src").append("\\test\\java\\");
        }
        int i = 0;
        for (String s : c.getName().split("\\.")) {
            i++;
            if (i == c.getName().split("\\.").length) {
                builder.append(s.toLowerCase()).append("\\");
            } else {
                builder.append(s).append("\\");
            }
        }
        dir = new File(builder.toString());
        if (!dir.isDirectory()) {
            dir.mkdir();
        }
        return builder.toString();
    }

    /**
     * Demo3Table.class utils
     *
     * @param c
     * @param polymerize
     * @return
     */
    public static String getTestDataDir(Class<?> c, String polymerize) {
        File dir = new File(System.getProperty("user.dir"));
        StringBuilder builder = new StringBuilder(128);
        if (StringUtils.isNotBlank(polymerize)) {
            builder.append(dir.toString()).append(File.separator).append(polymerize).append("\\").append("src").append("\\test\\java\\");
        } else {
            builder.append(dir.toString()).append(File.separator).append("src").append("\\test\\java\\");
        }
        int i = 0;
        for (String s : c.getName().split("\\.")) {
            i++;
            if (i == c.getName().split("\\.").length) {

            } else {
                builder.append(s).append("\\");
            }
        }
        dir = new File(builder.toString());
        if (!dir.isDirectory()) {
            dir.mkdir();
        }
        return builder.toString();
    }

    /**
     * Demo3Table.class utils
     *
     * @param c
     * @param polymerize
     * @return
     */
    public static String getMainDataDir(Class<?> c, String polymerize) {
        File dir = new File(System.getProperty("user.dir"));
        StringBuilder builder = new StringBuilder(128);
        if (StringUtils.isNotBlank(polymerize)) {
            builder.append(dir.toString()).append(File.separator).append(polymerize).append("\\").append("src").append("\\main\\java\\");
        } else {
            builder.append(dir.toString()).append(File.separator).append("src").append("\\main\\java\\");
        }
        int i = 0;
        for (String s : c.getName().split("\\.")) {
            i++;
            if (i == c.getName().split("\\.").length) {

            } else {
                builder.append(s).append("\\");
            }
        }
        dir = new File(builder.toString());
        if (!dir.isDirectory()) {
            dir.mkdir();
        }
        return builder.toString();
    }

    /**
     * 功能:压缩多个文件成一个zip文件
     *
     * @param srcFile：源文件列表
     * @param zipFile：压缩后的文件
     */
    public static void zipFiles(File[] srcFile, File zipFile) throws Exception {
        byte[] buf = new byte[1024];
        //ZipOutputStream类：完成文件或文件夹的压缩
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile));
        for (int i = 0; i < srcFile.length; i++) {
            FileInputStream in = new FileInputStream(srcFile[i]);
            out.putNextEntry(new ZipEntry(srcFile[i].getName()));
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.closeEntry();
            in.close();
        }
        out.close();
    }


    /**
     * 传入 字节流和文件名称
     *
     * @param fileName
     * @param bodys
     * @return
     */
    public ResponseEntity<byte[]> createResponse(String fileName, byte[] bodys) {
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<byte[]> responseEntity = null;
        String downloadFileName = null;
        try {
            downloadFileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
//            System.out.println("抛出异常:" + e.getMessage());
        }
        //解决下载显示的文件名问题
        headers.setContentDispositionFormData("attachment", downloadFileName);
        //二进制流数据(最常见的文件下载)
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        responseEntity = new ResponseEntity<byte[]>(bodys, headers, HttpStatus.CREATED);
        return responseEntity;
    }


    /**
     * 保存文件到硬盘指定目录
     *
     * @param filePath 文件路径
     * @param content  文件内容
     * @throws IOException
     */
    public static void saveFile(String filePath, byte[] content) throws IOException {
        BufferedOutputStream bos = null;
        try {
            File file = new File(filePath);
            folderMake(file.getParentFile());
            //创建文件（这是个空文件，用来写入上传过来的文件的内容）
            file.createNewFile();
            bos = new BufferedOutputStream(new FileOutputStream(file));
            bos.write(content);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("文件不存在。");
        } finally {
            if (null != bos) {
                bos.close();
            }
        }
    }

    /**
     * 删除磁盘指定目录下的文件
     *
     * @param sPath
     * @return
     */
    public static Boolean deleteFile(String sPath) {
        File file = new File(sPath);
        if (file.isFile()) {
            if (checkFileExists(file)) {
                file.delete();
                return true;
            }
        }
        return false;
    }

    /**
     * 检查文件目录是否存在
     *
     * @param file
     * @return
     */
    public static Boolean checkFileExists(File file) {
        if (file.exists()) {
            return true;
        }
        return false;
    }

    /**
     * 创建文件目录
     *
     * @param file
     */
    public static void folderMake(File file) {
        if (!file.exists()) {
            //文件路径不存在时，创建保存文件所需要的路径
            file.mkdirs();
        }
    }

    public static void folderMake(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            //文件路径不存在时，创建保存文件所需要的路径
            file.mkdirs();
        }
    }

    /**
     * 根据目录结构取得目录的绝对路径
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static String getFilePath(String filePath) throws IOException {
        File file = new File(System.getProperty("file.separator") + filePath);
        return file.getCanonicalPath();
    }

    /**
     * 下载文件
     *
     * @param name     下载文件的新名称
     * @param type     文件类型
     * @param path     下载文件的路径
     * @param response
     * @return
     * @throws Exception
     */
    public static boolean downLoadFile(String name, String type, String path, HttpServletResponse response)
            throws Exception {
        String fileName = name + "." + type;
        String fileType = type;
        File file = new File(path);  //根据文件路径获得File文件
        //设置文件类型(这样设置就不止是下Excel文件了，一举多得)
        if ("pdf".equals(fileType)) {
            response.setContentType("application/pdf;charset=GBK");
        } else if ("csv".equals(fileType)) {
            response.setContentType("application/msexcel;charset=GBK");
        } else if ("doc".equals(fileType)) {
            response.setContentType("application/msword;charset=GBK");
        } else if ("xls".equals(fileType)) {
            response.setContentType("application/msexcel;charset=GBK");
        }
        //文件名
        response.setHeader("Content-Disposition", "attachment;filename=\""
                + new String(fileName.getBytes(), "ISO8859-1") + "\"");
        response.setContentLength((int) file.length());
        byte[] buffer = new byte[4096];// 缓冲区
        BufferedOutputStream output = null;
        BufferedInputStream input = null;
        try {
            output = new BufferedOutputStream(response.getOutputStream());
            input = new BufferedInputStream(new FileInputStream(file));
            int n = -1;
            //遍历，开始下载
            while ((n = input.read(buffer, 0, 4096)) > -1) {
                output.write(buffer, 0, n);
            }
            output.flush();   //不可少
            response.flushBuffer();//不可少
        } catch (Exception e) {
            //异常自己捕捉
        } finally {
            //关闭流，不可少
            if (input != null)
                input.close();
            if (output != null)
                output.close();
        }
        return false;
    }

    /**
     * 修改文件的文件名
     *
     * @param file
     * @param toFile
     * @return
     * @throws Exception
     */
    public static boolean renameFile(String file, String toFile) throws Exception {
        File toBeRenamed = new File(file);
        //检查要重命名的文件是否存在，是否是文件
        if (!toBeRenamed.exists() || toBeRenamed.isDirectory()) {
            throw new Exception("文件不存在");
        }
        File newFile = new File(toFile);
        return toBeRenamed.renameTo(newFile);
    }

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     *
     * @param dir 将要删除的文件目录
     * @return boolean Returns "true" if all deletions were successful.
     * If a deletion fails, the method stops attempting to
     * delete and returns "false".
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }

    /**
     * 删除文件
     *
     * @param path        需要被删除的文件夹路径
     * @param notDelNames 不会被删除的文件夹名称
     * @return
     */
    public static void deleteDir(String path, List<String> notDelNames) {
        File file = new File(path);
        if (file != null && file.isDirectory()) {
            String[] list = file.list();
            for (String s : list) {
                for (String name : notDelNames) {
                    if (notDelNames.contains(s))
                        continue;
                    deleteDir(new File(file, s));
                }
            }
        }
    }

    /**
     * 读取文件内容
     *
     * @param path
     * @return
     */
    public static String getFileContent(String path) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(s);
            }
            br.close();
        } catch (Exception e) {

        }
        return result.toString();
    }

    public static String getFileContent(String path, String charsetName) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), charsetName));
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(s);
            }
            br.close();
        } catch (Exception e) {

        }
        return result.toString();
    }

    /**
     * 附件拷贝
     *
     * @param oldPath
     * @param newPath
     * @throws Exception
     */
    public static void copyFile(String oldPath, String newPath) throws Exception {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) { //文件存在时
                InputStream inStream = new FileInputStream(oldPath); //读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                int length;
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; //字节数 文件大小
                    System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            } else {
                throw new Exception("原文件不存在");
            }
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    /**
     * 获取后缀名称
     *
     * @param s
     * @param split
     * @return
     */
    public static String getExtName(String s, char split) {
        int i = s.lastIndexOf(split);
        int leg = s.length();
        return (i > 0 ? (i + 1) == leg ? " " : s.substring(i + 1, s.length()) : " ");
    }

    /**
     * 计算文件大小
     *
     * @param length
     * @return
     */
    public static String getSize(long length) {
        String fileSize;
        if (length < 1024) {
            fileSize = length + "B";
        } else {
            if (length < 1024 * 1024) {
                fileSize = (Math.round((length * 100) / 1024) / 100.0) + "KB";
            } else {
                fileSize = (Math.round((length * 100) / 1024 / 1024) / 100.0) + "MB";
            }
        }
        return fileSize;
    }

    /**
     * 根据文件名称及后缀名拼接文件名
     *
     * @param fileName
     * @param extension
     * @return
     */
    public static String joinFileName(String fileName, String extension) {
        String retFileName = null;
        int i = fileName.lastIndexOf(".");
        if (i <= 0) {
            retFileName = fileName + "." + extension;
        } else {
            retFileName = fileName.substring(0, i) + "." + extension;
        }
        return retFileName;
    }

    /**
     * 将输入流中的数据写入字节数组
     *
     * @param in
     * @return
     */
    public static byte[] inputStreamByteArray(InputStream in, boolean isClose) {
        byte[] byteArray = null;
        try {
            int total = in.available();
            byteArray = new byte[total];
            in.read(byteArray);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isClose) {
                try {
                    in.close();
                } catch (Exception e2) {
                    System.out.println("关闭流失败");
                }
            }
        }
        return byteArray;
    }

    /**
     * 注意： 该方法适用的图片格式为 bmp/gif/jpg/png
     *
     * @param path
     * @return
     */
    public static boolean checkImgSuffix(String path) {
        File file = new File(path);
        try {
            // 通过ImageReader来解码这个file并返回一个BufferedImage对象
            // 如果找不到合适的ImageReader则会返回null，我们可以认为这不是图片文件
            // 或者在解析过程中报错，也返回false
            Image image = ImageIO.read(file);
            return image != null;
        } catch (IOException ex) {
            return false;
        }
    }

    /**
     * @param base64String base64编码字符串
     * @param path   图片路径-具体到文件
     * @return
     * @Description: 将base64编码字符串转换为图片
     * @Author:
     * @CreateTime:
     */
    public static boolean base64ToImage(String base64String, String path) {
        if (base64String == null)
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // 解密
            byte[] b = decoder.decodeBuffer(base64String);
            // 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(path);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 创建不重复的文件名称
     *
     * @param suffix
     * @return
     */
    public static String createNoRepeatFileName(String suffix) {
        return UUID.randomUUID().toString().replace("-", "") + DateUtils.formatNowToYMDHMS() + "." + suffix.replaceAll("^\\.", "");
    }

    //拼接2-4张图片
    public static String getCombinationOfhead(List<String> paths) throws IOException {
        if (paths.size() == 1) return paths.get(0);
        List<BufferedImage> bufferedImages = new ArrayList<BufferedImage>();
        // 压缩图片所有的图片生成尺寸 250x250
        for (int i = 0; i < paths.size(); i++) {
            bufferedImages.add(FileUtils.resize(paths.get(i), 250, 247, true));
        }
        int width = 514; // 这是画板的宽高
        int height = 510; // 这是画板的高度
        BufferedImage outImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 生成画布
        Graphics g = outImage.getGraphics();
        Graphics2D g2d = (Graphics2D) g;
        // 设置背景色 白色
        g2d.setBackground(new Color(255, 255, 255));
        // 通过使用当前绘图表面的背景色进行填充来清除指定的矩形。
        g2d.clearRect(0, 0, width, height);
        // 开始拼凑 根据图片的数量判断该生成那种样式的组合头像目前为4中
        int j = 1;
        for (int i = 1; i <= bufferedImages.size(); i++) {
            if (bufferedImages.size() <= 4) {
                if (i <= 2) {
                    g2d.drawImage(bufferedImages.get(i - 1), 250 * i + 10 * i
                            - 260, 0, null);
                } else {
                    g2d.drawImage(bufferedImages.get(i - 1), 250 * j + 10 * j
                            - 260, 260, null);
                    j++;
                }
            }
        }
        String strDayTempDirName = DateUtils.formatNowToYMD();
        String localFileName = String.join("", strDayTempDirName, FilenameUtils.getName(paths.get(0)));
        String localDirPath = String.join(File.separator, org.apache.commons.io.FileUtils.getTempDirectoryPath(), strDayTempDirName);
        String localFullPath = String.join(File.separator, localDirPath, localFileName);
        File file = new File(localDirPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (new File(localFullPath).isFile()) {
            return localFullPath;
        }
        ImageIO.write(outImage, FilenameUtils.getExtension(localFullPath), new File(localFullPath));
        return localFullPath;
    }


    /**
     * 图片缩放
     *
     * @param filePath 图片路径
     * @param height   高度
     * @param width    宽度
     * @param bb       比例不对时是否需要补白
     */
    public static BufferedImage resize(String filePath, int height, int width,
                                       boolean bb) {
        try {
            File f = new File(filePath);
            BufferedImage bi = ImageIO.read(f);
            Image itemp = bi.getScaledInstance(width, height,
                    Image.SCALE_SMOOTH);
            if (bb) {
                BufferedImage image = new BufferedImage(width, height,
                        BufferedImage.TYPE_INT_RGB);
                Graphics2D g = image.createGraphics();
                g.setColor(Color.white);
                g.fillRect(0, 0, width, height);
                if (width == itemp.getWidth(null))
                    g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
                            itemp.getWidth(null), itemp.getHeight(null),
                            Color.white, null);
                else
                    g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
                            itemp.getWidth(null), itemp.getHeight(null),
                            Color.white, null);
                g.dispose();
                itemp = image;
            }
            return (BufferedImage) itemp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
