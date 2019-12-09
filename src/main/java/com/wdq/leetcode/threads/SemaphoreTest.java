package com.wdq.leetcode.threads;

import java.util.concurrent.Semaphore;

/**
 * @author wudq
 * @date 2019/8/6 000617
 * @Description: TODO
 */
public class SemaphoreTest {

    public static void main(String[] args) throws Exception{
        Semaphore semaphore = new Semaphore(0);
        semaphore.release();

        semaphore.acquire();
        System.out.println("申请资源");

    }


}
