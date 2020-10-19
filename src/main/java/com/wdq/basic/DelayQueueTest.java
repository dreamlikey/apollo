package com.wdq.basic;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author wudq
 * @date 2020/3/16
 */
public class DelayQueueTest {
    public static void main(String[] args) {
        DelayQueue delayQueue = new DelayQueue();
        delayQueue.add( "transportWay", 10);
        while (true) {
            try {
                List<Task> tasks = delayQueue.offer();
                if (tasks != null) {
                    System.out.println(tasks.get(0).getKey());
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
