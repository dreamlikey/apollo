package com.wdq.leetcode.algorithm;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * @author wudq
 * @date 2020/10/12
 */
public class _121_买卖股票的最佳时机 {
    public static void main(String[] args) {
        int[] g = {7,1,5,3,6,4};
        int[] g2 = {};
        int maxProfit = maxProfit(g2);
        System.out.println("maxProfit = " + maxProfit);
    }

    /**
     *
     * 从第二天开始每天都卖出股票，记录股票的 最低买入价格minPrice 当天价格包含在内price，
     * 当天的买入价格price与最低价格相减minPrice的利润与最大利润 maxProfit比较，记录交大的利润，最后得到最大利润
     * 时间负责读O(n),空间复杂度O(1)
     *
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int profit;
        int minPrice  = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            //最低价格
            minPrice  = minPrice < prices[i] ? minPrice : prices[i];
            profit = prices[i] - minPrice;
            maxProfit = maxProfit < profit ? profit : maxProfit;
        }

        return maxProfit;
    }
}
