package com.wdq.juc;

import java.util.concurrent.TimeUnit;

public class DeadLockDemo {
    private String locka = new String();
    private String lockb = new String();

    public static void main(String[] args) {
        DeadLockDemo lockDemo = new DeadLockDemo();
        new Thread(()->{lockDemo.testa();
        },"thread aaaa").start();
        new Thread(()->{
            lockDemo.testb();
        },"thread bbbb").start();
    }
    public void testa() {
        synchronized (locka) {
            System.out.println(Thread.currentThread().getName() +"获取locka锁" );
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockb) {
                System.out.println("执行业务aaaa");
            }
        }
    }
    public void testb() {
        synchronized (lockb) {
            System.out.println(Thread.currentThread().getName() +"获取lockb锁" );
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (locka) {
                System.out.println("执行业务bbbb");
            }
        }
    }
}
