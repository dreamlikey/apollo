package com.wdq.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wudq
 * @date 2019/8/7
 * @Description:
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class 两数之和 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,3,5,4,9,3,5,7,10,-2,7,-4,3,0,7,2,-2,-1,7,6};
        int target = 5;
        long startTime = System.currentTimeMillis();
        System.out.println();
        solution.twoSum(nums, 5);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime));
    }
}

/**
 * 解题
 * 1、暴力破解
 * 2、Hash遍历
 */
class Solution {
    public List<int[]> twoSum(int[] nums, int target) {
        List<int[]> result = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (indexList.contains(i)) {
                    continue;
                }
                int sum = nums[i] + nums[j];
                if (target == sum) {
                    indexList.add(i);
                    indexList.add(j);
                    System.out.println("["+i+","+j+"]");
                    result.add(new int[] {i,j});
                    continue;
                }
            }
        }
        return result;
    }
}