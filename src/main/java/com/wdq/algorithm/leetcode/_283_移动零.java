package com.wdq.algorithm.leetcode;

/**
 * @author wudq
 * @date 2020/11/02
 */
public class _283_移动零 {

    public static void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }

        for (int j = i; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public static void moveZeroes2(int[] nums) {
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            if (curr != i) {
                nums[curr] = nums[i];
                nums[i] = 0;
            }
            curr++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes2(nums);
        System.out.println("nums = " + nums);
    }
}
