package com.wdq.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wudq
 * @date 2020/11/02
 *
 * nums = [-1, 0, 1, 2, -1, -4]
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 */
public class _15_三数之和 {

    /**
     * 数组排序
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        //排序O(nlogn)
        Arrays.sort(nums);
        List<Integer> idxs;

        int sum;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int li = i+1;
            int ri = nums.length - 1;
            if (nums[i] > 0 || nums[ri] < 0) break;
            while (li < ri) {
                System.out.println("i = " + i + " li = " + li + " ri = " + ri);
                if (ri < nums.length - 1 && nums[ri] == nums[ri+1]) {
                    ri--;
                    continue;
                }
                sum = nums[i] + nums[li] + nums[ri];
                if (sum == 0) {
                    idxs = new ArrayList<>();
                    idxs.add(nums[i]);
                    idxs.add(nums[li]);
                    idxs.add(nums[ri]);
                    res.add(idxs);
                    //相邻数相同：跳过
                    if (nums[li] == nums[++li]) {
                        li++;
                    }
                    if (nums[ri] == nums[--ri]) {
                        ri--;
                    }
                    continue;
                }
                //ri--
                else if (sum > 0) {
                    ri--;
                }
                //li++
                else if (sum < 0) {
                    li++;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};[-1,0,1,2,-1,-4,-2,-3,3,0,4]
//        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        int[] nums = {-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0};
        List<List<Integer>> list = threeSum(nums);
        System.out.println("list = " + list.toString());

        int li = 1;

            ++li;
            li++;
            System.out.println(li);

    }
}
