package com.wdq.juc;

import com.wdq.T;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author wudq
 * @date 2020/6/6
 * @Description: synchronized可见性
 */
public class SyncVisible {

    int result;

    public synchronized int getResult() {
        return result;
    }

    public synchronized void setResult(int result) {
        this.result = result;
        System.out.println("result:"+result);
    }

    public static void main(String[] args) {
        SyncVisible threadSafeCache = new SyncVisible();

        for (int i = 0; i < 8; i++) {
            new Thread(() -> {
                int x = 0;
                while (threadSafeCache.getResult() < 100) {
                    x++;
                }
                System.out.println(x);
            }).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadSafeCache.setResult(200);
    }
}
