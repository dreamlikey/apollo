package com.wdq.leetcode.heap;

/**
 * 堆<br/>
 * <li>
 * 完全二叉树
 * 父节点都大于叶子结点
 * <li/>
 * @author wudq
 * @date 2020/10/09
 */
public class Heap {

    public Integer[] array;
    public int len;

    /**
     * 构造方法
     * @param array
     */
    public Heap(Integer[] array) {
        this.array = array;
        len = array.length;
    }

    /**
     * 建堆
     */
    public void buildHeap() {
        //最后一个非叶子节点(父节点)
        heapify((len - 1) >> 1);
    }

    /**
     * 堆化<br/>
     * 先找到堆的第一个非叶子节点<br/>
     * 所有非叶子结点，逐一下沉，直到根结点也完成下沉，就是整棵完全二叉树堆化完成<br/>
     */
    public void heapify(int index) {
        if (index < 0) {
            return;
        }
        shiftDown(index);
        heapify(--index);
    }

    /**
     * 对index位置的元素执行上浮操作
     * @param index
     */
    public void shiftUp(int index) {
        int p = index >> 1;
        while (index > 0 && cmp(index >> 1, index) < 0) {
            swap(p, index);
            index = p;
            p = index >> 1;
        }
    }

    /**
     * 下沉<br/>
     * 父节点与更大的子节点交换，
     * 交换之后的子节点继续与它的子节点比较，直到叶子节点
     * @param index
     */
    public void shiftDown(int index) {
        //当前index是叶子节点，退出循环
        while (lc(index) < len) {
            int l = lc(index);
            int r = rc(index);
            //与更大的子节点交换，【如果右子节点越界，使用左子节点】
            int max = r > len - 1 ? l : cmp(l, r) > 0 ? l : r;
            if (cmp(index, max) < 0) {
                swap(index, max);
                index = max;
            }
        }
    }

    /**
     * 左子节点 index
     * @param index
     * @return
     */
    private int lc(int index) {
        return (index * 2) + 1;
    }

    /**
     * 右子节点 index
     * @param index
     * @return
     */
    private int rc(int index) {
        return (index + 1) * 2;
    }

    /**
     * 堆排序
     */
    public void sort() {

    }

    /**
     * 交换
     * @param i1
     * @param i2
     */
    private void swap(int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    /**
     * 比较
     * @param i1
     * @param i2
     * @return
     */
    private int cmp(int i1, int i2) {
        return array[i1] - array[i2];
    }

    public static void main(String[] args) {
        Integer[] arrays = new Integer[]{1,3,4,5,7,6,2,8,0,9};
        Heap heap = new Heap(arrays);
        heap.buildHeap();
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i]);
        }
    }

}
