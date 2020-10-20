package com.wdq.datastructure.数组;

import java.util.Arrays;

/**
 * @author wudq
 * @date 2019/8/15 001509
 * @Description: TODO
 */
public class 简单_有序数组的平方 {
    public static void main(String[] args) {
        Solution_sortedSquares ss = new Solution_sortedSquares();
//        int[] A = {-4,-1,0,3,10};
//        int[] A = {-1,2,2};
//        int[] A = {0,1,3,4};
        int[] A = {-4,-3,-3,-2,2};
        int[] res = ss.sortedSquares(A);
        System.out.println(ss.sortedSquares(A));
    }
}

/**
 * 给定一个按非递减顺序排序的整数数组 A，
 * 返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 */
class Solution_sortedSquares {
    /**
     * 流计算
     */
    public int[] sortedSquares(int[] A) {
        return Arrays.stream(A).map(x -> x*x).sorted().toArray();
    }

    public int[] sortedSquares_2(int[] A) {
        return null;
    }
}