package com.ng.todo.select;

import cn.hutool.core.lang.UUID;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SelectOtherTest {


    @Test
    public void test1(){
        List<String> strings = Lists.newArrayList(UUID.fastUUID().toString(),UUID.fastUUID().toString()) ;
        String[] array = strings.toArray(new String[strings.size()]);

        System.out.println(Arrays.toString(array));
    }

}
