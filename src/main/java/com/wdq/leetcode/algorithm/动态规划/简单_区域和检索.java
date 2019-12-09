package com.wdq.leetcode.algorithm.动态规划;

/**
 * @author wudq
 * @date 2019/8/14
 * @Description: TODO
 */
public class 简单_区域和检索 {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray_cache cache = new NumArray_cache(nums);
        System.out.println(cache.sumRange(0, 2));
        System.out.println(cache.sumRange(2, 5));
        System.out.println(cache.sumRange(0, 5));
    }
}

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 *
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 *
 */
class NumArray {
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }
    //依然是暴力
    public int sumRange(int i, int j) {
        int sum = 0;
        for (;i <=j; i++) {
            sum += nums[i];
        }
        return sum;
    }
}

class NumArray_cache {
    private int[] sums;
    public NumArray_cache(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i+1] = nums[i] + sums[i];
        }
    }

    /**
     * 缓存
     * sumrange（i，j）=sum[j+1]−sum[i]
     */
    public int sumRange(int i, int j) {
        return sums[j+1] - sums[i];
    }
}
