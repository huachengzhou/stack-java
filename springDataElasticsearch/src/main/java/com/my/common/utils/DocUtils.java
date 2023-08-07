package com.my.common.utils;

public class DocUtils {

    public int getTable(String table){
        int num = 0;
        byte[] bytes = table.getBytes();
        for (byte b:bytes){
            num += b;
        }
        return num;
    }

}
