package com.my.test;

import org.junit.Test;

public class Demo3 {

    @Test
    public void test1(){
        String v1 = "hello" ;
        byte[] bytes = v1.getBytes();
        int count = 0;
        for (byte b:bytes){
            count += b;
        }
        System.out.println(count);
    }

}
