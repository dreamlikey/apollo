package com.wdq.algorithm.leetcode.threads;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author wudq
 * @date 2019/8/6
 * @Description:
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 * 线程 A 将调用 zero()，它只输出 0 。
 * 线程 B 将调用 even()，它只输出偶数。
 * 线程 C 将调用 odd()，它只输出奇数。
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 *
 * 输入：n = 5
 * 输出："0102030405"
 */
public class 打印零和奇偶数 {

    public static void main(String[] args) {

        ZeroEvenOdd zeo = new ZeroEvenOdd(10);

        new Thread(() -> {
            try {
                zeo.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeo.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeo.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

/**
 * 信号量
 * semaphoreZero：1，互斥锁的作用，一开始只会有一个线程获取成功
 * semaphoreEven：0，一开始没有资源，等待release()会将信号量改为1，线程获取成功
 */
class ZeroEvenOdd {

    private Semaphore semaphoreZero = new Semaphore(1);

    private Semaphore semaphoreEven = new Semaphore(0);

    private Semaphore semaphoreOdd = new Semaphore(0);

    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            semaphoreZero.acquire();
            printNumber.accept(0);
            if ((i&1) == 0) {
                semaphoreEven.release();
            } else {
                semaphoreOdd.release();
            }
        }
    }
    //偶数
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            semaphoreEven.acquire();
            printNumber.accept(i);
            semaphoreZero.release();
        }
    }
    //奇数
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            semaphoreOdd.acquire();
            printNumber.accept(i);
            semaphoreZero.release();
        }
    }
}