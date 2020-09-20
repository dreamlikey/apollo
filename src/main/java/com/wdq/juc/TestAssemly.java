package com.wdq.juc;

import sun.misc.Unsafe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wudq
 * @date 2020/5/26 0026
 * @Description: TODO
 */
public class TestAssemly {

    private int a;
    public synchronized void add(int i) {
        a = a++;

    }
    public static void main(String[] args) {
        TestAssemly test = new TestAssemly();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                test.add(1);
            }).start();
        }

    }
}
