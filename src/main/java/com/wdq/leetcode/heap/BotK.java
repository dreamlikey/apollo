package com.wdq.leetcode.heap;

/**
 * BottomK 找出k个最小元素<br/>
 * 从海量数据中找出前K个数据
 * 比如 : 从100万个整数中找出最小的100个整数
 *
 * 大顶堆
 * @author wudq
 * @date 2020/10/10
 */
public class BotK {
    Integer[] tops;
    Integer[] arrays;

    /**
     * bottom操作，找出最小的top个
     * @param data
     * @param top
     */
    public void bottom(Integer[] data, int top) {
        tops = new Integer[top];
        arrays = data;
        //前top个元素直接存放
        for (int i = 0; i < top; i++) {
            tops[i] = arrays[i];
        }
        //大顶堆
        Heap heap = new MaxHeap(tops);
        heap.buildHeap();
        doBottom(heap);
    }

    /**
     * 获取top个元素，并升序排序
     * @param heap 排序的堆类型
     */
    private void doBottom(Heap heap) {
        int len = arrays.length;
        int top = tops.length;

        //剩余数据与堆顶逐一比较
        for (int i = top; i < len; i++) {
            //堆顶 比 数据大 交换，执行shiftDown操作，保证堆顶是最大
            if (tops[0] > arrays[i]) {
                tops[0] = arrays[i];
                heap.shiftDown(0, top - 1);
            }
        }
        //升序（小顶堆）
        heap.sort();
    }
}
