package com.wdq.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 *
 * @author wudq
 * @date 2020/12/24
 */
@Slf4j
public class SyncWaitSet {
    static final Object lock = new Object();
    static List<Thread> list = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                synchronized (lock) {
                    try {
                        log.error("thread executed : {}", Thread.currentThread().getName());
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"t"+(i+1));
            list.add(thread);
        }

        log.error("----启动顺序");
        synchronized (lock) {
            for (Thread thread : list) {
                log.error(" 正在顺序启动 : {}", thread.getName());
                thread.start();
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.error("------正在顺序执行，正序10-1");
        }

    }

}
