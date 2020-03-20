package com.wdq;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wudq
 * @date 2020/1/9
 */
public class TestCpu {
    private static ReentrantLock lock = new ReentrantLock(true);
    public static void main(String[] args) {
        while (true) {
            System.out.println(new Random().nextInt(200000));
        }
    }
}
