package com.wdq.juc;

import java.sql.Time;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wudq
 * @date 2020/1/15
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        testProConsumer();
    }

    public void testSyncQueue() {
        SynchronousQueue<String> queue = new SynchronousQueue();
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    queue.put("a");
                    System.out.println(Thread.currentThread().getName() + " put");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"thread a").start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " take " + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"thread b").start();
        }
    }

    /**
     * 测试生产者消费者
     */
    public static void testProConsumer() {
        Product product = new Product();
            new Thread(()->{
                for (int i = 0; i < 5; i++) {
                    product.incr();
                }
            },"aa").start();
            new Thread(()->{
                for (int i = 0; i < 5 ; i++) {
                    product.decr();
                }
            },"bb").start();
            new Thread(()->{
                for (int i = 0; i < 5; i++) {
                    product.incr();
                }
            },"cc").start();
            new Thread(()->{
                for (int i = 0; i < 5 ; i++) {
                    product.decr();
                }
            },"dd").start();
    }
}

/**
 * 生产1 消费1
 * 生产者消费者
 */
class Product {
    private int number = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void incr() {

        lock.lock();
//        lock.tryLock();
        try {
            TimeUnit.SECONDS.sleep(1);
            //虚假唤醒
//            if (number >= 1) {
//                condition.await();
//            }
            //await状态线程唤醒之后继续判断number>=1
            while (number >= 1) {
                condition.await();
            }

            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        }catch(Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void decr() {
        lock.lock();
//        lock.tryLock();
        try {
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}

