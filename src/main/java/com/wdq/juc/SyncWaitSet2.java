package com.wdq.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 *
 * @author wudq
 * @date 2020/12/24
 */
@Slf4j
public class SyncWaitSet2 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        List<Thread> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                lock.lock();
                try {
                    log.error("thread executed : {}", Thread.currentThread().getName());
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            },"t"+(i+1));
            list.add(thread);
        }

        log.error("----启动顺序");
        lock.lock();
        for (Thread thread : list) {
            log.error(" 正在顺序启动 : {}", thread.getName());
            thread.start();
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.unlock();
        log.error("------正在顺序执行，正序10-1");

    }

}
