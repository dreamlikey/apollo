package com.wdq.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者  消费者
 * 生产一个 消费一个 5次
 * 虚假唤醒问题
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        Product2 product = new Product2();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                    product.incr();
            }
        },"aa").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                    product.decr();
            }
        },"bb").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                    product.incr();
            }
        },"cc").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                    product.decr();
            }
        },"dd").start();

    }

}


class Product2 {
    private int number = 0;
    //共享锁
    private ReentrantLock lock = new ReentrantLock();
    //共享condition
    private Condition condition = lock.newCondition();
    public void incr() {
        lock.lock();
        try {
            if (number != 0 ) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t"+number);
            //唤醒所有等待线程，包括wait和blocked两种状态的线程T
            condition.signalAll();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void decr() {
        lock.lock();
        try {
            //虚假唤醒
            //因为 signalAll()是唤醒所有等待的线程去拿锁，包括wait和blocked两种状态的线程
            //如果是blocked状态的线程先拿到锁执行number-- 当被await线程拿到锁时number的值已经变了
            if (number == 0 ) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t"+number);
            condition.signalAll();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}