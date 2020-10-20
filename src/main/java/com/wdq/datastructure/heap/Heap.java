package com.wdq.datastructure.heap;

/**
 * 堆<br/>
 * 完全二叉树
 * 父节点都大于叶子结点
 * @author wudq
 * @date 2020/10/09
 */
public abstract class Heap {

    public Integer[] array;
    public int len;

    public Heap() {
    }

    /**
     * 建堆
     */
    public void buildHeap() {
        //最后一个非叶子节点(父节点)
        heapify((len >> 1) - 1);
    }

    /**
     * 建堆
     */
    public void buildHeap(Integer[] array) {
        this.array = array;
        len = array.length;
        //最后一个非叶子节点(父节点)
        heapify((len - 1) >> 1);
    }

    /**
     * 堆化<br/>
     * 先找到堆的第一个非叶子节点<br/>
     * 所有非叶子结点，逐一下沉，直到根结点也完成下沉，就是整棵完全二叉树堆化完成<br/>
     * @param index
     */
    public void heapify(int index) {
        if (index < 0) {
            return;
        }
        shiftDown(index, len-1);
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
     * @param len
     */
    protected abstract void shiftDown(int index, int len);

    /**
     * 左子节点 index
     * @param index
     * @return
     */
    protected int lc(int index) {
        return (index * 2) + 1;
    }

    /**
     * 右子节点 index
     * @param index
     * @return
     */
    protected int rc(int index) {
        return (index + 1) * 2;
    }

    /**
     * 堆排序<br/>
     * 堆顶与最后一个元素交换，排除最后一个元素并 执行一次shiftDown（下沉）操作（保证堆顶最大），
     * 重复此操作直到最后两个元素
     */
    public void sort() {
        buildHeap();
        for (int i = len - 1; i > 0; i--) {
            swap(0, i);
            shiftDown(0, i - 1);
        }
    }

    /**
     * 交换
     * @param i1
     * @param i2
     */
    protected void swap(int i1, int i2) {
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
    protected int cmp(int i1, int i2) {
        return array[i1] - array[i2];
    }
}
