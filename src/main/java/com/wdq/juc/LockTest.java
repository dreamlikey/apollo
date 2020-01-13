package com.wdq.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wudq
 * @date 2020/1/9 0009
 * @Description: TODO
 */
public class LockTest {
    private static ReentrantLock lock = new ReentrantLock(true);
    public static void main(String[] args) {
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获取锁");
                TimeUnit.SECONDS.sleep(5);
            }catch(Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "释放锁");
                lock.unlock();
            }
        },"t1").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 开始执行任务");
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获取锁");
            }catch(Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "释放锁");
                lock.unlock();
            }
        },"t2").start();
    }
}
