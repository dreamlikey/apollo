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
        if (amount < 1 || coins == null || coins.length == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i < coins[j] || dp[i - coins[j]] < 0 || dp[i - coins[j]] >= min)
                    continue;
                min = dp[i - coins[j]];
            }
            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }
        }

        return dp[amount];
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

//        int[] coins = {186,419,83,408};
//        int[] coins = {3,5,20,25};
        int[] coins = {1};
//        int i = coinChange(coins, 41);
//        System.out.println("i = " + i);

        int i1 = change1(coins, 0);
        System.out.println("i1 = " + i1);

    }

    /**
     * 暴力递归
     * 列出所有硬币凑到n分需要的最少硬币数 dp[n] = dp[n-coin] + 1
     * 取出最小的那个
     * @param coins
     * @return
     */
    public static int change1(int[] coins, int amount) {
        if (amount < 1 || coins == null || coins.length == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i < coins[j] || dp[i - coins[j]] < 0 || dp[i - coins[j]] >= min)
                    continue;
                min = dp[i - coins[j]];
            }
            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }
        }

        return dp[amount];
    }
}
