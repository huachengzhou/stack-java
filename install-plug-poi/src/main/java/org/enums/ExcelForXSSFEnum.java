package org.enums;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/9/24
 **/
public enum  ExcelForXSSFEnum {
    A_Path("E:\\doc\\test\\");
    private String path;

    ExcelForXSSFEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
