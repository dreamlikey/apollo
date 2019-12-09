package com.wdq.leetcode.algorithm.数组;

/**
 * @author wudq
 * @date 2019/8/19
 * @Description:
 */
public class 简单_移除元素 {
    public static void main(String[] args) {
        Solution_removeElement sr = new Solution_removeElement();
        int[] nums = {0,1,2,2,3,0,4,2};
//        System.out.println(sr.removeElement(nums,2));
        System.out.println(sr.removeElement_2(nums,2));
    }
}

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *
 * 注意这五个元素可为任意顺序。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 */
class Solution_removeElement {
    public int removeElement(int[] nums, int val) {
        int j = nums.length -1;
        for (int i = nums.length -1; i>=0; i--) {
            if (nums[i] == val) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j--;
            }
        }
        return j+1;
    }

    public int removeElement_2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}