package com.wdq.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wudq
 * @date 2020/10/18
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 */
public class _48_最长不含重复字符的子字符串 {

    /**
     * 动态规划
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        if (chars == null) {
            return 0;
        }
        Map<Character, Integer> dic = new HashMap<>();
        int max = 0;
        int len = 0;
        for (int i = 0; i < chars.length; i++) {

            if (dic.get(chars[i]) == null) {
                dic.put(chars[i], i);
                len++;
            } else {
                dic.put(chars[i], i);
                len = 0;
            }
            System.out.println(len);
            if (len > max) {
                max = len;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
         s = " ";
        int i = lengthOfLongestSubstring(s);
        System.out.println("i = " + i);
    }
}
