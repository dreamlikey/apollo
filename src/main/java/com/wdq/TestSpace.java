package com.wdq;

import java.util.Random;

public class TestSpace {
    public static void main(String[] args) {
//        byte[] bytes = new byte[20*1024*1024];
        String str = "asdasd";
        while (true) {
            str  += str + new Random().nextInt(1000);
            str.intern();
        }
    }
}
