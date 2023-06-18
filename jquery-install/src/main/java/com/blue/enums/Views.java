package com.blue.enums;

/**
 * @Auther: zch
 * @Date: 2018/7/30 21:05
 * @Description:
 */
public enum  Views {
    NAVIGATION("navigation/","模型视图常量"),
    EasyUI("easyUIView/","模型视图常量"),
    BASE_VIEW("baseView/","模型视图常量"),
    VALIDATION("validationView/","模型视图常量"),
    CORE_VIEW("coreView/","模型视图常量"),
    WEB_INF("WEB-INF/","WEB-INF视图模型");
    private String var;
    private String temp;

    private int size;

    Views(String var) {
        this.var = var;
    }

    Views(int size) {
        this.size = size;
    }

    Views(String var,String temp){
        this.var = var;
        this.temp = temp;
    }

    public int getSize() {
        return size;
    }

    public String getVar() {
        return var;
    }
}
