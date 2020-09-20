package com.wdq.leetcode.algorithm.动态规划;

/**
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4]
 */
public class 一维数组的动态和 {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(dpSubset(nums).toString());
    }

    /**
     * 动态规划
     * 集合：runningSum[i] = sum(nums[0]…nums[i])
     * 属性：
     * @param nums
     * @return
     */
    public static int[] dpSubset(int[] nums) {
        int len = nums.length;
        int[] sums = new int[len];
        sums[0] = nums[0];
        for (int i = 1; i < len; i++) {
          sums[i] = sums[i-1] + nums[i];
        }
        return sums;
    }
}
