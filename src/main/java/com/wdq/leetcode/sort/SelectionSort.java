package com.wdq.leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wudq
 * 选择排序
 *1/ 从序列中找出最大的元素与末尾交换
 *2/ 忽略曾经找到的最大元素，重复步骤1
 */
public class SelectionSort<E extends Comparable<E>> extends Sort<E> {

    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0;  end--) {
            int index = 0;
            for (int begin = 1; begin <= end ; begin++) {
                if (cmp(array[begin], array[index]) > 0) {
                    index = begin;
                }
            }
            E temp = (E) array[end];
            array[end] = array[index];
            array[index] = temp;
        }
    }

    public static void main(String[] args) {
        Integer[] array = {2,4,2,3,9,3,5,7,6,19,23,11,1};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort();
        System.out.println(Arrays.toString(array));
    }
}
