package com.wdq.algorithm.leetcode;

/**
 * @author wudq
 * @date 2020/10/19
 */
public class 最长公共子串 {
    /**
     * 动态规划
     * dp状态：dp[i][j]表示字符串A下标i 与 子串B下标j的最大公共子串
     *  1、如果i、j位置的字符相同， dp[i][j] = dp[i-1][j-1] + 1
     *  2、不同 dp[i][j] = 0
     */
    public static int lcsSubStr(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        int len = 0;
        for (int i = 1; i < chars1.length; i++) {
            for (int j = 1; j < chars2.length; j++) {
                if (chars1[i] != chars2[j])
                    continue;
                dp[i][j] = dp[i-1][j-1] + 1;
                len = Math.max(dp[i][j], len);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "DBCDA";
        int len = lcsSubStr(s1, s2);
        System.out.println("len = " + len);
    }
}
