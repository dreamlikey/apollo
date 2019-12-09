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
        Random rand = new Random();
        for (int i = 0 ; i< 10; i++) {
            // 取0-3之间的一个随机值
            int chanceInt = rand.nextInt(3);
            System.out.println(chanceInt);
        }

    }

    static final int hash(Object key) {
        int h;
        h = key.hashCode();
        System.out.println(h);
        h = h >>> 16;
        return (h = key.hashCode()) ^ (h >>> 16);
    }

}
