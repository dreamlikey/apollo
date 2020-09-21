package com.wdq.leetcode.algorithm.动态规划;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 1、单调队列
 * 2、双指针
 * 3、动态规划
 * @author wudq
 * @date 2020/09/21
 */
public class 滑动窗口最大值2 {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] windowDeque = maxSlidingWindow_deque(nums, 3);
        System.out.println(Arrays.toString(windowDeque));
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
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

    /**
     * 单调队列
     *
     * int nums = {1,3,-1,-3,5,3,6,7};
     * window                   deque
     * 1,3,-1					3 -1
     *   3,-1,-3				3 -1 -3
     *     -1,-3,5				5
     *        -3,5,3			5 3
     *           5,3,6			6
     *             3,6,7		7
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow_deque(int[] nums, int k) {
        int len = nums.length;
        if (len == 0 || k == 0) {
            return new int[0];
        }
        int[] maxs = new int[len - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            //出队 1、形成窗口 2、队头元素 == 窗口前一元素
            if (i >= k && deque.getFirst() == nums[i-k]) {
                deque.removeFirst();
            }
            //递减  小于当前元素的 元素删除，递减排列队头最大
            while (!deque.isEmpty() && nums[i] > deque.getLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            System.out.println(i + Arrays.toString(deque.toArray()));
            if (i >= k - 1) {
                maxs[i - k + 1] = deque.peekFirst();
            }
        }
        return maxs;
    }
}
