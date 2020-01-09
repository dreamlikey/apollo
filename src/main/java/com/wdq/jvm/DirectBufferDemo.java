package com.wdq.jvm;

import java.nio.ByteBuffer;

/**
 * @author wudq
 * @date 2020/1/4
 * @Description: 测试直接内存
 */
public class DirectBufferDemo {
    /**
     * ByteBuffer.allocateDirect(capacity);通过Native方法分配用户空间内存也就是堆外内存
     * ByteBuffer.allocate(capacity);分配jvm堆内存
     * 当直接内存满了之后 ，再次尝试分配直接内存就会出现OutOfMemory
     */
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(5 * 1024 *1024);
    }
}
