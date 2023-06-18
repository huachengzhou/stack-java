package com.gold.tree.test;

import com.google.common.base.Optional;

import java.util.Arrays;
import java.util.stream.Stream;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<Integer> integerOptional = Optional.fromNullable(6);
        Integer integer = integerOptional.orNull();
        System.out.println(integer);

        Stream<Integer> integerStream = Stream.of(2,null,3) ;
        Stream<Integer> limit = integerStream.filter(obj -> obj != null).limit(3);
        limit.forEach(integer1 -> System.out.println(integer1));
    }
}
