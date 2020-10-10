package com.wdq.leetcode.sort;


/**
 * @author wudq
 * 插入排序
 * 第二个元素开始与前面的元素一一比较，
 *  如果当前元素小与前一个元素交换位置，继续与前一个元素比较
 *  如果当前元素较大 或 已经比较完最后一个元素，则开始比较第三个元素，
 *  重复此过程直到数组的最后一个元素
 */
public class InsertionSort extends Sort {

    @Override
    protected void sort() {
        int curr;
        for (int i = 1; i < array.length; i++) {
            curr = i;
            while (curr > 0 && cmp(curr, curr - 1) < 0) {
                    swap(curr, curr - 1);
                    curr--;
            }
        }
    }
}
