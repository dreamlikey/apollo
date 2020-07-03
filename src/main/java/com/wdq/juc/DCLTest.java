package com.wdq.juc;

/**
 * @author wudq
 * @date 2020/5/26
 * @Description: 单例 double check lock
 */
public class DCLTest {

    /**
     * volatile修饰instance，instance的操作加上内存屏障防止指令重排序
     * 汇编指令上加了一个lock 指令
     * 为什么要加volatile
     * instance = new Object();
     * 分为几个步骤
     * 1、堆内存分配空间，成员变量赋初值m=0
     * 2、调用构造方法 成员变量赋值m=8
     * 3、内存地址 赋给 instance变量
     *
     * 可能存在cpu对指令优化时先 将内存地址赋值给instance 然后再给成员变量赋值
     * 此时，另外一个线程调用getInstance()发现instance != null，于是就返回，
     * 当外部逻辑使用intance对象时，对象的变量还没完成初始化，值还是是初始值m=0
     *
     *
     *
     */
    private volatile static Instance instance = null;

    public static Instance getInstance() {
        //one check
        if (instance == null) {
            synchronized (DCLTest.class) {
                //double check
                if (instance == null) {
                    instance = new Instance();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {

//        for (int i = 0; i < 100; i++) {
//            new Thread(()->{
                DCLTest.getInstance();
//            }).start();
//        }
    }
}

class Instance {
    int m = 8;
}