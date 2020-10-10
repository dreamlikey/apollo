package com.wdq.leetcode.heap;

/**
 * topk问题<br/>
 * 从海量数据中找出前K个数据
 * 比如 : 从100万个整数中找出最大的100个整数
 *
 * 小顶堆
 * @author wudq
 * @date 2020/10/10
 */
public class TopK {
    Integer[] tops;
    Integer[] arrays;

    /**
     * top操作，最大的top个
     * @param data 数据
     * @param top  top数
     */
    public void top(Integer[] data, int top) {
        tops = new Integer[top];
        arrays = data;
        //前top个元素直接存放
        for (int i = 0; i < top; i++) {
            tops[i] = arrays[i];
        }
        //小顶堆
        Heap heap = new MinHeap(tops);
        //建堆
        heap.buildHeap();
        doTop(heap);
    }

    /**
     * 获取top个元素，并排序
     * @param heap 排序的堆类型
     */
    private void doTop(Heap heap) {
        int len = arrays.length;
        int top = tops.length;

        //剩余数据与堆顶逐一比较
        for (int i = top; i < len; i++) {
            //堆顶 比 数据小 交换，执行shiftDown操作，保证堆顶是最小
            if (tops[0] < arrays[i]) {
                tops[0] = arrays[i];
                heap.shiftDown(0, top - 1);
            }
        }
        //降序（大顶堆）
        heap.sort();
    }
}
