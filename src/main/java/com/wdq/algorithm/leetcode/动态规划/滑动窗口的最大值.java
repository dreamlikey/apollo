package com.wdq.algorithm.leetcode.动态规划;

import java.util.Arrays;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 */
public class 滑动窗口的最大值 {
    public static void main(String[] args) {
        int k = 2;
        int[] nums = {1,3};
        int[] maxSlidingWindow = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(maxSlidingWindow));
    }

    /**
     * 状态表示
     * <li>集合定义<li/>
     * 长度为K且下标连续的子集合
     * <li>属性<li/>
     *  最大值
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 1) {
            return nums;
        }

        int maxs[] = new int[nums.length - k + 1];
        int maxsLen = maxs.length;
        int temp = 0;

        for (int i = 0; i < k ; i++) {
            //重新遍历出最大值
            temp = Math.max(temp, nums[i]);
        }
        maxs[0] = Math.max(temp, nums[k - 1]);
        if (k == nums.length) {
            return maxs;
        }

        for (int i = 1; i < maxsLen; i++) {
            //前一子数组的最大值 小于 当前值
            if (maxs[i-1] <= nums[i + k -1]) {
                maxs[i] = nums[i + k -1];
                //前一子数组的最大值 在当前 子数组中
            } else if (maxs[i-1] > nums[i-1]) {
                maxs[i] = Math.max(maxs[i-1], nums[i + k -1]);
            } else {
                temp = 0;
                for (int j = 0; j < k ; j++) {
                    //重新遍历出最大值
                    temp = Math.max(temp, nums[i+j]);
                }
                maxs[i] = Math.max(temp, nums[i + k -1]);
            }
        }
        return maxs;
    }
}
