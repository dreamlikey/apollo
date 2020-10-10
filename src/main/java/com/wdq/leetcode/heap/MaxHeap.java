package com.wdq.leetcode.heap;

/**
 * 大顶堆
 * @author wudq
 * @date 2020/10/10
 */
public class MaxHeap extends Heap{
    /**
     * 构造方法
     * @param array
     */
    public MaxHeap(Integer[] array) {
        this.array = array;
        this.len   = array.length;
    }

    /**
     * 下沉<br/>
     * 父节点与更大的子节点交换，
     * 交换之后的子节点继续与它的子节点比较，直到叶子节点
     * @param index 父节点索引值
     * @param len   最后节点索引值
     */
    @Override
    public void shiftDown(int index, int len) {
        //当前index是叶子节点，退出循环
        while (lc(index) <= len) {
            int l = lc(index);
            int r = rc(index);
            //与更大的子节点交换，【如果右子节点越界，使用左子节点】
            int max = r > len ? l : cmp(l, r) > 0 ? l : r;
            if (cmp(index, max) >= 0) {
                break;
            }
            swap(index, max);
            index = max;
        }
    }
}
