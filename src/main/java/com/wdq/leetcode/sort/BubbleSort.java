package com.wdq.leetcode.sort;

import java.util.Arrays;

/**
 * @author wudq
 * 冒泡排序
 */
public class BubbleSort<E extends Comparable<E>> extends Sort<E> {

    @Override
    protected void sort() {
        //从后向前比较，大的交换到最后
        for (int end = array.length - 1; end > 0; end--) {
            for (int begin = 0; begin <= end ; begin++) {
                //第i个依次与前面的比较，如果比当前比较元素小交换元素，
                // 大则不交换，然后继续拿第i个与前面的比较，直到比较到第0 个元素
                if (cmp(array[end], array[begin]) < 0) {
                    E temp = array[end];
                    array[end] = array[begin];
                    array[begin] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = {2,4,2,3,9,3,5,7,6,19,23,11,1};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
