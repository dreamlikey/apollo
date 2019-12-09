package com.wdq.leetcode.algorithm;

/**
 * @author wudq
 * @date 2019/8/9
 * @Description:
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
public class 中等_回文子串 {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        String res = solution.longestPalindrome("u6ureeeeeeeeeeeeeeeeeeeeeeru");
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

}