package com.wdq.algorithm.leetcode;

/**
 *
 * @author wudq
 * @date 2019/8/9
 * @Description:
 *
 * #5
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 回文子串即从左往右输出和从右往左输出结果是一样的字符串，
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 */
public class _5_中等_回文子串 {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        String res = solution.longestPalindrome("u6ureeeeeeeeeeeeeeeeeeeeeeru");
        System.out.println(res);

        res = solution.longestPalindrome_dp("u6ureeeeeeeeeeeeeeeeeeeeeeru");
        System.out.println(res);
    }
}


/**
 * 暴力破解
 * 动态规划
 * 中心扩展
 * Manacher算法
 */
class Solution4 {

    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            //相邻字符相同
            int len2 = expandAroundCenter(s, i,i+1);
            int len = Math.max(len1, len2);
            if (len > end -start) {
                end = i + len/2;
                start = i - (len-1)/2;
            }
        }
        return s.substring(start, end+1);
    }
    //中心扩展法
    //i-1 == i+1继续比较
    private int expandAroundCenter(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() &&
            s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R-L-1;
    }


    /**
     * 动态规划
     * 1、s[i,j]  的长度 j - i + 1<= 2时
     *
     * s[i] == s[j] 则s[i,j]是回文子串dp[i] [j] = true
     *
     * 2、s[i,j]  的长度 j - i + 1> 2时
     *
     * 如果 dp[i+1] [j-1] 是回文子串，并且 s[i] == s[j] 则 s[i,j]是回文子串
     *
     * dp[i] [j] = true
     * 其它情况不是回文子串
     *
     * 由于dp状态 由dp[i+1] [j-1] 决定，所以要先求解出dp[i+1] [j-1]的状态，也就是说 **从上到下 从左往右的顺序**求出dp状态
     * @param s
     * @return
     */
    public String longestPalindrome_dp(String s) {
        int max   = 1, len;
        int start = 0, end = 0;
        char[] chars = s.toCharArray();
        int[][] dp = new int[chars.length][chars.length];
        for (int j = 0; j < chars.length; j++) {
            for (int i = 0; i <= j ; i++) {
                len = j - i + 1;
                //j - i + <= 2
                if (len <= 2) {
                    if (chars[i] == chars[j]) {
                        dp[i][j] = 1;
                        if (len > max) {
                            max = len;
                            start = i;
                            end = j;
                        }
                    }
                } else {   //j - i + > 2
                    if (chars[i] == chars[j] && dp[i+1][j-1] == 1) {
                        dp[i][j] = 1;
                        if (len > max) {
                            max = len;
                            start = i;
                            end = j;
                        }
                    }
                }
            }
        }

        return s.substring(start, end+1);
    }

}