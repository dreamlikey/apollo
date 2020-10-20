package com.wdq.datastructure.数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author wudq
 * @date 2019/8/15 001515
 * @Description: TODO
 */
public class 简单_数组交集 {
    public static void main(String[] args) {
        Solution_intersection si = new Solution_intersection();
        int[] nums1 = {9,4,9,8,4};
        int[] nums2 = {4,9,5};
        int[] nums = si.intersection(nums1,nums2);
        for (int num : nums) {
            System.out.println(num);
        }

    }
}

/**
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 *
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 */
class Solution_intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while (i<nums1.length) {
            map.put(nums1[i], i);
            i++;
        }
        int j = 0;
        while (j < nums2.length) {
            if (null != map.get(nums2[j])) {
                list.add(nums2[j]);
                map.remove(nums2[j]);
            }
            j++;
        }
        int[] outPut = new int[list.size()];
        for (int a=0; a< outPut.length;a++) {
            outPut[a] = list.get(a);
        }
        return outPut;
    }

    /**
     * 两个set分别存储两个数组
     * set不重复
     * set.retainAll取交集
     *
     */
    public int[] intersection_set(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);

        set1.retainAll(set2);

        int [] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) output[idx++] = s;
        return output;
    }
}