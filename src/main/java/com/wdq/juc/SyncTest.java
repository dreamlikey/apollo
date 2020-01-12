package com.wdq.juc;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class SyncTest {
    public static void main(String[] args) {
        for(int i =0; i<=5; i++) {
            new Thread(SyncTest::test1).start();
        }
    }

    //修饰静态方法
    public synchronized static void test1() {
        try {
            System.out.println(Thread.currentThread().getName()+ "---test1");
            TimeUnit.MINUTES.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //修饰非静态方法
    public synchronized void test2() {
        try {
            System.out.println(Thread.currentThread().getName()+ "---test2");
            TimeUnit.MINUTES.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //修饰代码块 (this)当前对象
    public void test3() {
        synchronized(this) {
            try {
                System.out.println(Thread.currentThread().getName()+ "---test2");
                TimeUnit.MINUTES.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //修饰代码块 Class类
    public void test4() {
        synchronized(SyncTest.class) {
            try {
                System.out.println(Thread.currentThread().getName()+ "---test2");
                TimeUnit.MINUTES.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
