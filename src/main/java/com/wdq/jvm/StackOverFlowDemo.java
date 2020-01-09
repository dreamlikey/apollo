package com.wdq.jvm;

/**
 * @author wudq
 * @date 2020/1/4 0004
 * @Description: TODO
 */
public class StackOverFlowDemo {
    public static void main(String[] args) {
        overFlow();
    }

    public static void overFlow() {
        overFlow();
    }
}
