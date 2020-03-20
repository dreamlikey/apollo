package com.wdq;

import org.openjdk.jol.info.ClassLayout;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * @author wudq
 * @date 2019/2/27
 * @Description: TODO
 */
public class Test {
    byte i = 0;
    short s = 0;
    long j = 0;
    int k = 1;
    public static void main(String[] args) {
            //签章比率配置（比如2/1则E签宝概率2/3,安心签1/3）
            String rateStr = "1/0";
            String[] bounds = rateStr.split("/");
            int eSignBound = Integer.valueOf(bounds[0]);
            int anxinSignBound = Integer.valueOf(bounds[1]);
            Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            int chanceInt = rand.nextInt(eSignBound+anxinSignBound);
            //依据随机整数值所在的边界，来确定签章渠道
            System.out.println(chanceInt >= eSignBound ?  "anxinsign" : "esign");
        }

    }

}
