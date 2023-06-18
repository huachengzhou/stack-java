package org.enums;

import java.io.Serializable;

/**
 * 排版设计字体对应表
 * @author zch
 */
public enum MakeUpEnum implements Serializable {

    XIAO_LIU("小六 " ,6.5 ,2.29) ,
    XIAO_WU("小五 " ,9 ,3.18) ,
    XIAO_SI("小四" ,12,4.35) ,
    XIAO_SAN("小三 " ,15 ,5.29) ,
    XIAO_ER("小二 " ,18 ,6.35) ,
    XIAO_YI("小一 " ,24 ,8.47) ,
    XIAO_FIRST("小初 " ,36 ,12.7) ,
   FIRST_NUMBER("初号 " ,42 ,14.82) ,


    first("一号" ,26,9.17),
    second("二号",22,7.76),
    third("三号",16,5.64),
    fourth("四号",14,4.94),
    fifth("五号",10.5,3.7),
    sixth("六号 ",7.5,2.65),
    seventh("七号",5.5,1.94),
    eighth("八号",5,1.74),
    ;

    private String fontName;//
    private double millimeter;//磅
    private double pound;//毫米

    MakeUpEnum(String fontName, double millimeter, double pound) {
        this.fontName = fontName;
        this.millimeter = millimeter;
        this.pound = pound;
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public double getMillimeter() {
        return millimeter;
    }

    public void setMillimeter(double millimeter) {
        this.millimeter = millimeter;
    }

    public double getPound() {
        return pound;
    }

    public void setPound(double pound) {
        this.pound = pound;
    }
}
