package com.wdq.algorithm.leetcode;

import java.util.Arrays;

/**
 *
 * @author wudq
 * @date 2020/10/21
 */
public class _322_零钱兑换 {


    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int count = 0;
        for (int i = coins.length - 1; i >= 0; ) {
            if (amount < coins[i]) {
                i--;
                continue;
            }

            amount -= coins[i];
            count++;
            System.out.println(coins[i] +" " + amount);
        }
        return amount > 0 ? -1 : count;
    }

    /**
     * 动态规划
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange2(int[] coins, int amount) {

        return 0;
    }

    /**
     * 回溯
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange3(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount];
        dp[0] = 1;
        for (int i = 1; i <= coins.length; i++) {

        }

        return 0;
    }



    public static void main(String[] args) {
//        [186,419,83,408]

        int[] coins = {186,419,83,408};
        int i = coinChange(coins, 6249);
        System.out.println("i = " + i);
    }
}
