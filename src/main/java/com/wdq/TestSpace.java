package com.wdq;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class TestSpace {
    public static void main(String[] args) {
//        byte[] bytes = new byte[20*1024*1024];
//        String str = "asdasd";
//        while (true) {
//            str  += str + new Random().nextInt(1000);
//            str.intern();
//        }
//        List<String> list = Collections.EMPTY_LIST;
        List<String> list = null;
        int size = Optional.ofNullable(list).orElse(Collections.EMPTY_LIST).size();
        System.out.println(size);
    }
}
