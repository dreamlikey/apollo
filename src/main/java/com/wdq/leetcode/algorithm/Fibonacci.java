package com.wdq.leetcode.algorithm;

/**
 *
 * @author wudq
 * @date 2020/09/23
 */
public class Fibonacci {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(fib_rec(40));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);

        System.out.println(fib_dp(40));
        long endTime2 = System.currentTimeMillis();
        System.out.println(endTime2-endTime);

        System.out.println(fib(40));
        long endTime3 = System.currentTimeMillis();
        System.out.println(endTime3-endTime2);

    }

    /**
     * 递归
     * 大量重复计算，时间复杂度O(2^n)
     * 空间复杂度O(1)，有额外栈空间
     * @param n
     * @return
     */
    public static int fib_rec(int n) {
        if (n <= 2) {
            return 1;
        }
        return fib_rec(n-1) + fib_rec(n-2);
    }

    /**
     * 动态规划
     * 时间复杂度 O(n)  O(3n)
     * 空间复杂度 O(n)
     * @param n
     * @return
     */
    public static long fib_dp(int n) {
        long[] array = new long[n];
        array[0] = 1;
        array[1] = 1;
        for(int i = 2; i < n; i++) {
            array[i] = array[i-1] + array[i-2];
        }
        return array[n-1];
    }

    /**
     * 最优解
     * @param n
     * @return
     */
    public static long fib(int n) {
        int first = 1;
        int second = 1;
        for(int i = 2; i < n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }

}
