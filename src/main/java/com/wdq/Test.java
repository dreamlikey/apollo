package com.wdq;

import java.util.concurrent.TimeUnit;

/**
 * @author wudq
 * @date 2019/2/27
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(TimeUnit.MINUTES.toMillis(10));
        String key = "aedqwert";
        int h = key.hashCode();
        h = (h >>> 16);
        System.out.println("h = " + h);
    }

}
