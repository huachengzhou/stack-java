package com.blue.common;


public enum ViewEnum {
    WEB("WEB-INF/","敏感目录"),
    EASY("easy/","easyUi树目录"),
    ZTREE("ztree/","ztree树目录"),
    Bootstrap("bootstrap/","ztree树目录"),
    JQUERY("jquery/","jquery树目录"),
    DataGrid("dataGrid/","easyUi树目录"),
    TREE("tree/","easyUi树目录"),
    JSP("jsp/","jsp目录");
    private String key;
    private String name;

    ViewEnum(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return key;
    }
}
