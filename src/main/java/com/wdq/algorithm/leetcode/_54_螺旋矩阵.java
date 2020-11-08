package com.wdq.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wudq
 * @date 2020/11/08
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 *
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 */
public class _54_螺旋矩阵 {

    /**
     * 螺旋遍历
     *
     * int top = 0;
     *         int bot = matrix.length - 1;
     *         int left = 0;
     *         int right = matrix[0].length - 1;
     *
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return Collections.emptyList();

        int top = 0;
        int bot = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        List<Integer> list = new ArrayList<>(matrix.length + matrix[0].length);
        while (top <= bot && left <= right) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            for (int i = top ; i <= bot; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            if (top > bot || left > right) break;

            for (int i = right; i >= left; i--) {
                list.add(matrix[bot][i]);
            }
            bot--;

            for (int i = bot; i >= top ; i--) {
                list.add(matrix[i][left]);
            }
            left++;
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][] {{ 1, 2, 3},{ 4, 5, 6}};
        List<Integer> list = spiralOrder(ints);
        System.out.println("list = " + list);

    }
}
