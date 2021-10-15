package com.wdq.algorithm.leetcode;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 *
 * //给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * //
 * // 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
 * //ms2 的元素。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * //输出：[1,2,2,3,5,6]
 * @author wudq
 * @date 2021/06/01
 */
public class _88_合并两个有序数组 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int start = m - 1;
        for (int i = 0; i < n; i++) {
            int index = start;
            while ( index >= 0 && nums1[index] > nums2[i]) {
                nums1[index + 1] = nums1[index];
                index--;
            }
            nums1[index + 1] = nums2[i];
            start++;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0 };
        int[] nums2 = {2,5,6 };
        merge(nums1, 0, nums2, 0);
        System.out.println("nums1 = " + nums1);
    }
}
