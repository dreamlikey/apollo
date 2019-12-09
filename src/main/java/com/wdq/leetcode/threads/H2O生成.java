package com.wdq.leetcode.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wudq
 * @date 2019/8/6
 * @Description:
 * 现在有两种线程，氢 oxygen 和氧 hydrogen，你的目标是组织这两种线程来产生水分子。
 *
 * 存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。
 *
 * 氢和氧线程会被分别给予 releaseHydrogen 和 releaseOxygen 方法来允许它们突破屏障。
 *
 * 这些线程应该三三成组突破屏障并能立即组合产生一个水分子。
 *
 * 你必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。
 *
 * 换句话说:
 *
 * 如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。
 * 如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。
 * 书写满足这些限制条件的氢、氧线程同步代码。
 *
 * 输入: "OOHHHH"
 * 输出: "HHOHHO"
 * 解释: "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH" 和 "OHHOHH" 依然都是有效解。
 *
 */
public class H2O生成 {
    public static void main(String[] args) {

        H2O h2O = new H2O();

        for (int i = 0; i < 8; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        h2O.hydrogen(new Runnable() {
                            @Override
                            public void run() {
                                System.out.print("H");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"threadH"+i).start();
        }

        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        h2O.oxygen(new Runnable() {
                            @Override
                            public void run() {
                                System.out.print("O");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"threadO"+i).start();
        }
    }
}


/**
 * 解题方式
 * 1、加锁
 * 2、信号量
 */
class H2O {

    private int hyNum;

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized (this) {
            while (hyNum == 2) {
                this.wait();
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            hyNum+=1;
            this.notifyAll();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        synchronized (this) {
            while (hyNum != 2) {
                this.wait();
            }
            // releaseOxygen.run() outputs "H". Do not change or remove this line.
            releaseOxygen.run();
            hyNum = 0;
            this.notifyAll();
        }

    }
}