package com.wdq.algorithm.leetcode.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wudq
 * @date 2019/8/6
 * @Description:
 *  交替打印，两个线程共用同一个FooBar实例，
 *  其中一个线程将会调用 foo() 方法，
 *  另一个线程将会调用 bar() 方法。
 *  交替打印foobar
 */
public class 交替打印 {

    static ExecutorService pool = Executors.newScheduledThreadPool(2);

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(5);

        Thread foo = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("foo");
            }
        });
        Thread bar = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("bar");
            }
        });

        pool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar(bar);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        pool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(foo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}


/**
 * 注意执行wait、notify首先要获取到对象的锁
 */
class FooBar {

    private boolean fooFlag = Boolean.TRUE;
    private boolean barFlag = Boolean.FALSE;

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (!fooFlag) {
                    this.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                fooFlag = Boolean.FALSE;
                barFlag = Boolean.TRUE;
                this.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (!barFlag) {
                    this.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();

                fooFlag = Boolean.TRUE;
                barFlag = Boolean.FALSE;
                this.notifyAll();
            }
        }
    }
}