package com.wdq.leetcode.threads;

import org.hibernate.annotations.Synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wudq
 * @date 2019/8/6
 * @Description:
 */
public class 顺序执行 {

    static ExecutorService pool = Executors.newScheduledThreadPool(3);

    public static void main(String[] args) throws Exception{
        Foo foo = new Foo();

        Thread printFirst = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("one");
            }
        });
        Thread printSecond = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("two");
            }
        });
        Thread printThird = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("three");
            }
        });



        pool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.second(printSecond);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        pool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.third(printThird);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        pool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first(printFirst);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        pool.shutdown();
    }
}

/**
 * 1：加锁
 */
class Foo {

    private boolean hasPrintFirst = Boolean.FALSE;

    private boolean hasPrintSecond = Boolean.FALSE;

    private Object lock = new Object();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        synchronized (lock){
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            hasPrintFirst = Boolean.TRUE;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        synchronized (lock) {
            while (!hasPrintFirst) {
                lock.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            hasPrintSecond = Boolean.TRUE;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (!hasPrintSecond) {
                lock.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}