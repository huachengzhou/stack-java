package spring;

public class StringDemo {
    public static void main(String[] args) {
        System.out.println(org.springframework.util.StringUtils.containsWhitespace("sfas"));//是否有空白 false
        System.out.println(org.springframework.util.StringUtils.trimWhitespace(" - dfasd- "));//去除前后空格
        System.out.println(org.springframework.util.StringUtils.trimAllWhitespace(" - - - - fshjk     s j - -"));//去除所有空格
        System.out.println(org.springframework.util.StringUtils.trimLeadingWhitespace("  - - - - fshjk     s j - - "));//去除第字符串开头的空格
        System.out.println(org.springframework.util.StringUtils.trimTrailingWhitespace("  - - - - fshjk     s j - - "));//去除第字符串结尾的空格
        System.out.println(org.springframework.util.StringUtils.substringMatch("f sdfc",2,"sd"));//判断字符串第几个位置起为某值
        System.out.println(org.springframework.util.StringUtils.countOccurrencesOf("qwertyrtttttt", "t"));//判断字符串字符重复次数
        System.out.println(org.springframework.util.StringUtils.replace("yuiyuiyui", "y", "m"));//字符替换
        System.out.println(org.springframework.util.StringUtils.delete("yuiyuiyui", "y"));//删除匹配的字符
        System.out.println(org.springframework.util.StringUtils.deleteAny("yuiyuiyui", "yi"));//删除出现且匹配的字符
        System.out.println(org.springframework.util.StringUtils.quote("yuiyuiyui"));//为字符串加上''号
        System.out.println(org.springframework.util.StringUtils.unqualify("yuiyuiy.ui"));//字符串截取，，从'.'号+1的未知开始
        System.out.println(org.springframework.util.StringUtils.unqualify("yuiyuiy.ui",'y'));//字符串截取，，从字符最后出现的位置+1开始
        System.out.println(org.springframework.util.StringUtils.capitalize("yuiyuiy"));//首字母大写
        System.out.println(org.springframework.util.StringUtils.uncapitalize("YuIyuiy"));//首字母小写
        System.out.println(org.springframework.util.StringUtils.uncapitalize("YuIyuiy"));//首字母小写 changeFirstCharacterCase(String str, boolean capitalize),capitalize为true则为大写
        System.out.println(org.springframework.util.StringUtils.getFilename("D://Java"));//截取最后一个\出现的未知+1的字符串 Java
        System.out.println(org.springframework.util.StringUtils.getFilenameExtension("D:/Java.fdsdf"));//获取路劲下的后缀名 fdsdf
        System.out.println(org.springframework.util.StringUtils.stripFilenameExtension("D:/Java.fdsdf"));//获取路劲下的后缀名之前的部分 D:/Java
    }
}
