package com.test.blue;

import org.junit.Test;

/**
 * @author : chengdu
 * @date :  2023/8/12-08
 **/
public class MyPreciseShardingAlgorithmTest {

    @Test
    public void test1() {
        for (int i = 0; i < 20; i++) {
            int two = i % 2;
//            System.out.println("i:" + i + " % 2:" + two);
//            System.out.println("i:" + i + " % 3:" + i % 3);
            System.out.println("i:" + i + " % 3:" + i % 4);
        }
    }

}
