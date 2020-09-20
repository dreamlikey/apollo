package com.wdq.leetcode.algorithm.插入排序;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wudq
 * @date 2020/6/12
 * @Description: 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[10000];
        int i = 0;
        while (i < arr.length) {
            arr[i] = new Random().nextInt(100000);
            i++;
        }
        long startTime = System.currentTimeMillis();
        arr = insertSort(arr);
        long endTime = System.currentTimeMillis();
        int[] sortArr = Arrays.copyOf(arr, 1000);
        System.out.println("耗时："+ (endTime - startTime));
        System.out.println(Arrays.toString(sortArr));
    }

    public static int[] insertSort(int[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return arr;
        }
        int temp;
        int j;
        for (j =1; j < arr.length; j++) {
            for (int i = j; i>0; i--) {
                if (arr[i] >= arr[i-1]) {
                    break;
                }
                temp = arr[i-1];
                arr[i-1] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }
}
