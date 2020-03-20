package com.wdq.basic;

import java.util.concurrent.TimeUnit;

/**
 * @author wudq
 * @date 2020/3/16
 */
public class DelayQueueTest {
    public static void main(String[] args) {
        DelayQueue delayQueue = new DelayQueue();

        while (true) {
            try {
                Task task = delayQueue.offer();
                if (task !=null) {
                    System.out.println(task.getKey());
                }else {
                    System.out.println("null");
                }
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
