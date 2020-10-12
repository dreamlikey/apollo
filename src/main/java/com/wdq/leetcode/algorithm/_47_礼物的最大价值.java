package com.wdq.leetcode.algorithm;

/**
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 * @author wudq
 * @date 2020/10/12
 */
public class _47_礼物的最大价值 {

    public static void main(String[] args) {
//        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] grid = {{1,3,1},{1,5,1}};
        int maxValue = maxValue(grid);
        System.out.println("maxValue = " + maxValue);
    }

    /**
     *
     *
     *
     * 1、先计算第一行、第一列的最大值（单一路线，累加）
     * 2、逐行从左到右 比较计算最大值，最大值 = 左边元素 与 上边元素的最大值 + 当前网格元素的值<br/>
     *      dp[row][col] = max(dp[row][col-1], dp[row-1][col]) + grid[row][col] <br/>
     * @param grid
     * @return
     */
    public static int maxValue(int[][] grid) {
        int rlen = grid.length;
        int clen = grid[0].length;
        int[][] max = grid;
        max[0][0] = grid[0][0];

        //第一行的最大值
        for (int col = 1; col < clen ; col++) {
            max[0][col] = max[0][col - 1] + grid[0][col];
        }

        //第一列的最大值
        for (int row = 1; row < rlen; row++) {
            max[row][0] = max[row-1][0] + grid[row][0];
        }

        //逐行从左到右 比较计算最大值，最大值 = 左边元素 与 上边元素的最大值 + 当前网格元素的值
        for (int row = 1; row < rlen; row++) {
            for (int col = 1; col < clen; col++) {
                max[row][col] = Math.max(max[row][col-1], max[row-1][col]) + grid[row][col];
            }
        }
        return max[rlen - 1][clen - 1];
    }
}
