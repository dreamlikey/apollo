package com.wdq.algorithm.leetcode;

/**
 * #300
 * @author wudq
 * @date 2020/10/25
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class _300_最长上升子序列 {

    /**
     * 动态规划
     * dp[i]当前位置最长子序列长度：
     * 与前面每一个进行比较后获取最大值，比较规则有下面两种情况
     *  1、nums[index] > nums[pre]，则dp[index] = dp[pre] + 1
     *  2、nums[index] <= nums[pre] dp[index] = 1
     *  记录并比较dp[index]的最大值
     *
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j], dp[i]);
                }
            }
            dp[i] += 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    //最大值
    //是否比最大值位置的元素 大
    public static void main(String[] args) {
//        int[] nums = {10,9,2,5,3,8,6,7,9,101,18};
        int[] nums = {1,3,6,7,9,4,10,5,6};
        int i = lengthOfLIS(nums);
        System.out.println("i = " + i);
    }
}
