package com.wdq.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author wudq
 * @date 2020/11/1
 */
public class _40_最小的K个数 {

    /**
     * jdk 类库排序
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr == null || arr.length == 0)
            return new int[0];
        Arrays.sort(arr);
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }


    private static int array[];

    /**
     * 快速排序
     */
    public static int[] getLeastNumbers2(int[] arr, int k) {
        array = arr;
        sort(0, arr.length);
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private static void sort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        int mid = pivot(begin, end);

        sort(begin, mid);
        sort(mid + 1, end);
    }

    /**
     * 找到中轴点
     * 大于      中轴点元素 放到右侧   交换比较方向到左侧
     * 小于等于  中轴点元素 的放左侧   交换比较方向到右侧
     * @param begin
     * @param end
     */
    private static int pivot(int begin, int end) {
        int pivot = array[begin];
        end--;
        //
        while(begin < end) {
            while (begin < end) {
                //右侧元素 > 中轴点  元素不变 end--
                if (pivot < array[end]) {
                    end--;
                } else { //右侧元素 <= 中轴点 end元素复制到begin，begin++
                    array[begin] = array[end];
                    begin++;
                    break;
                }
            }

            while(begin < end) {
                //左侧元素 <= 中轴点  元素不变 begin++
                if (pivot > array[begin]) {
                    begin++;
                } else {//左侧元素 > 中轴点 begin元素复制到end，end--
                    array[end] = array[begin];
                    end--;
                    break;
                }
            }
        }

        array[begin] = pivot;
        return begin;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        int[] numbers2 = getLeastNumbers2(arr, 2);
        System.out.println("numbers2 = " + numbers2);
    }
}
