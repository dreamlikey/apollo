package com.wdq.datastructure.sort;


/**
 * @author wudq
 * 堆排序
 * 1/对数组原地建堆
 * 2/ 重复执行一下操作直到堆的数量为1
 *  交换堆顶元素与尾元素
 *  堆size-1
 *  对0位置进行一次shiftDown操作
 */
public class HeapSort extends Sort {


    /**
     * 堆排序<br/>
     * 堆顶与最后一个元素交换，<p>排除最后一个元素<p/> 并执行一次shiftDown（下沉）操作（保证堆顶最大），
     * 重复此操作直到最后两个元素
     */
    @Override
    public void sort() {
        buildHeap();
        for (int i = array.length - 1; i > 0; i--) {
            swap(0, i);
            //i-1 排除最后一个元素
            shiftDown(0, i - 1);
        }
    }

    /**
     * 堆化<br/>
     * 先找到堆的第一个非叶子节点<br/>
     * 所有非叶子结点，逐一下沉，直到根结点也完成下沉，就是整棵完全二叉树堆化完成<br/>
     */
    public void heapifyRa(int index) {
        if (index < 0) {
            return;
        }
        shiftDown(index, array.length);
        heapifyRa(--index);
    }

    public void heapify(int index) {
        for (int i = index; i >= 0 ; i--) {
            shiftDown(i, array.length);
        }
    }

    /**
     * 建堆
     */
    public void buildHeap() {
        //最后一个非叶子节点(父节点)
        heapify((array.length - 1) >> 1);
    }

    /**
     * 下沉<br/>
     * 父节点与更大的子节点交换，如果父节点是最大直接退出shiftdown，
     * 交换之后的子节点继续与它的子节点比较，直到叶子节点
     * @param index
     */
    public void shiftDown(int index, int len) {
        //当前父节点的左子节点大于len，认为当前index是叶子节点，退出循环
        while (lc(index) <= len) {
            int l = lc(index);
            int r = rc(index);
            //与更大的子节点交换，【如果右子节点越界，使用左子节点】
            int max = r > len - 1 ? l : cmp(l, r) > 0 ? l : r;
            if (cmp(index, max) >= 0) {
                break;
            }
            swap(index, max);
            index = max;
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
}
