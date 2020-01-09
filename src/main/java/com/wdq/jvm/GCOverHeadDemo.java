package com.wdq.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wudq
 * @date 2020/1/4
 * @Description:
 */
public class GCOverHeadDemo {
    /**
     * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=1m
     * 一直向堆内存添加对象，一直发生GC，但是GC效果不明显，导致很大部分CPU算力进行GC回收，
     * 只有少部分CPU进行程序运行，事倍工微，最终java抛出java.lang.OutOfMemoryError: GC overhead limit exceeded错误
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e) {
            System.out.println("********************** "+i);
            e.printStackTrace();
            throw e;
        }

    }
}
