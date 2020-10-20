package com.wdq.algorithm.leetcode;

import java.util.Random;

/**
 * @author wudq
 * @date 2019/8/13
 * @Description:
 *
 */
public class 中等_盛最多水的容器 {
    public static void main(String[] args) {
        Solution_area area = new Solution_area();
        int[] height = new int[5000];
        for (int i=0; i <5000;i++) {
            height[i] = new Random().nextInt(100);
        }
        long start = System.currentTimeMillis();
//        System.out.println(area.maxArea(height));
        System.out.println(area.maxArea_point(height));
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start));
    }
}

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)
 * 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 1、暴力破解
 * 2、双指针法
 * 双指针发比暴力破解高效很多
 */
class Solution_area {
    public int maxArea(int[] height) {
        int area = 0;
        for (int i=0; i< height.length; i++) {
            for (int j = i+1; j<height.length; j++) {
                int high = Math.min(height[i], height[j]);
                int len = j - i;
                area = Math.max(area, high * len);
            }
        }
        return area;
    }
    /**
     * 双指针
     *
     * 最初我们考虑由最外围两条线段构成的区域。现在，为了使面积最大化，
     * 我们需要考虑更长的两条线段之间的区域。
     * 如果我们试图将指向较长线段的指针向内侧移动，
     * 矩形区域的面积将受限于较短的线段而不会获得任何增加。
     * 但是，在同样的条件下，移动指向较短线段的指针尽管造成了矩形宽度的减小，
     * 但却可能会有助于面积的增大。因为移动较短线段的指针会得到一条相对较长的线段，
     * 这可以克服由宽度减小而引起的面积减小。
     *
     * @param height
     * @return
     */
    public int maxArea_point(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}