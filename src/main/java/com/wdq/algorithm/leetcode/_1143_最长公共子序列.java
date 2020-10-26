package com.wdq.algorithm.leetcode;

/**
 * @author wudq
 * @date 2020/10/26
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 *
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 */
public class _1143_最长公共子序列 {
    /**
     * 动态规划
     * dp状态：dp[i,j]表示0-i 和 0-j的最长公共子序列长度
     * 状态转移方程：
     *  1、nums[i-1] == nums[j-1]，dp[i,j] = dp[i-1,j-1] + 1
     *  2、nums[i-1] != nums[j-1]，dp[i,j] = max(dp[i-1,j], dp[i,j-1])
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] dp = new int[chars1.length+1][chars2.length+1];
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if (chars1[i-1] == chars2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[chars1.length][chars2.length];
    }

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        int i = longestCommonSubsequence(text1, text2);
        System.out.println("i = " + i);
    }
}
