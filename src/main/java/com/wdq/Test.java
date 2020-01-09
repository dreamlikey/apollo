package com.wdq;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * @author wudq
 * @date 2019/2/27
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        Integer i1 = 127;
        Integer i2 = new Integer(127);
        Integer i3 = 127;
        System.out.println(i1 == i2);
        System.out.println(i1 == i3);
    }

    static final int hash(Object key) {
        int h;
        h = key.hashCode();
        System.out.println(h);
        h = h >>> 16;
        return (h = key.hashCode()) ^ (h >>> 16);
    }

}
