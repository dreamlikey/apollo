package com.wdq.algorithm.leetcode;

/**
 * #53
 * @author wudq
 * @date 202/10/22
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 *
 */
public class _53_最大子序列和 {

    /**
     * 暴力
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }


    /**
     * 分治 + 递归
     * O(nlogn)
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        return maxSubArray(nums, 0, nums.length);
    }

    public static int maxSubArray(int[] nums, int begin, int end) {
        if (2 > end - begin) {
            return nums[begin];
        }
        int mid = (begin + end) >> 1;
        int leftMax = Integer.MIN_VALUE;
        int leftSum = 0;
        for (int i = mid - 1; i >= begin; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }
        int rightMax = Integer.MIN_VALUE;
        int rightSum = 0;
        for (int i = mid; i < end; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }
        int max = Math.max(maxSubArray(nums, begin, mid), maxSubArray(nums, mid, end));
        return Math.max(max, rightMax + leftMax);
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int max = maxSubArray1(nums);
        System.out.println("max = " + max);
    }
}
