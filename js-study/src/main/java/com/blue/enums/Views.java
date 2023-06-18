package com.blue.enums;

/**
 * @Auther: zch
 * @Date: 2018/7/30 21:05
 * @Description:
 */
public enum  Views {
    Example("example/","模型视图例子学习常量"),
    templates("templates/","模型视图"),
    canvas("canvas/","模型视图"),
    WEB_INF("WEB-INF/","WEB-INF模型视图 学习主页")
    ;
    private String key;
    private String name;

    Views(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return key;
    }
}
