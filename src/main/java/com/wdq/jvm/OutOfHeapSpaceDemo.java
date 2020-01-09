package com.wdq.jvm;

/**
 * @author wudq
 * @date 2020/1/4 0004
 * @Description: TODO
 */
public class OutOfHeapSpaceDemo {
    public static void main(String[] args) {
        //-Xms10m -Xmx10m 设置初始化最大堆内存大小10m, 声明一个20m大小数组
        //程序异常java.lang.OutOfMemoryError: Java heap space
        byte[] bytes = new byte[20* 1024* 1024];
    }
}
