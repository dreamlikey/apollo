package com.wdq;

/**
 * @author wudq
 * @date 2020/6/6 0006
 * @Description: TODO
 */
public class T {
    private static volatile int i = 0;
    public static synchronized void m() {

    }
    public static void n() {
        i = 1;
    }

    public static void main(String[] args) {
        for (int j = 0; j < 100000; j++) {
            m();
            n();
        }        
    }
}
