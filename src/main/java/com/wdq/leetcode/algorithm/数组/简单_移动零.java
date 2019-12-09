package com.wdq.leetcode.algorithm.数组;

/**
 * @author wudq
 * @date 2019/8/15
 * @Description:
 */
public class 简单_移动零 {
    public static void main(String[] args) {
        Solution_moveZeroes sm = new Solution_moveZeroes();
        int[] nums = {0,1,0,3,12};
        int[] nums1 = {0,1,0,3,12,0};
//        sm.moveZeroes(nums);
        sm.moveZeroes(nums1);
    }
}

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:么
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 */
class Solution_moveZeroes {
    public void moveZeroes(int[] nums) {
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] != 0) {
                continue;
            }
            for (int j=i; j<nums.length-1; j++) {
                if (nums[j+1] != 0) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        System.out.println();
    }

    public void moveZeroes_2(int[] nums) {
        //i:插入位置下标 ; j:查找位置下标
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != 0){
                nums[i] = nums[j];
                i++;
            }
        }
        //将后面的位置补0
        for(int p = i; p < nums.length; p++){
            nums[p] = 0;
        }
    }

}
