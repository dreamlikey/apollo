package com.wdq.leetcode.algorithm;

/**
 * @author wudq
 * @date 2020/10/19
 */
public class _70_爬楼梯 {
    /**
     * 递归
     * 时间复杂度O(2^n)，效率非常低
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if(n <= 2) {
            return n;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    /**
     * 优化
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        int first = 1;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }


    public static void main(String[] args) {
        int stairs = climbStairs2(3);
        System.out.println("stairs = " + stairs);
    }
}
