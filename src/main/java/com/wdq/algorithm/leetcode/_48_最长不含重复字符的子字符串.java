package com.wdq.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * #48 中等<br/>
 * 1、滑动窗口
 * 算法 algorithm
 * 数据结构 data structure
 * 策略
 * @author wudq
 * @date 2020/10/18
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
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
     * 暴力判断
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Integer pi;
        Map<Character, Integer> dic = new HashMap<>();
        int max = 0, len = 0, si = 0;
        for (int i = 0; i < chars.length; i++) {
            pi = dic.get(chars[i]);
            if (pi != null) {
                if (pi == si) {
                    len = i - si;
                    si = pi + 1;
                } else if (pi > si) {
                    len = i - pi;
                    si = pi;
                } else if (pi < si) {
                    len = i - si;
                }
            } else {
                len++;
            }
            max = len > max ? len : max;
            dic.put(chars[i], i);
        }
        return max;
    }

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        //窗口起始位置
        int si = 0, len = 0, max = 0;
        Integer pi;
        Map<Character, Integer> dic = new HashMap<>();
        //滑动
        for (int i = 0; i < chars.length; i++) {
            pi = dic.get(chars[i]);
            if (pi != null && pi >= si) {
                si = pi + 1;
            }
            len = i - si + 1;
            max = len > max ? len : max;
            dic.put(chars[i], i);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        s = "abcabcbb";
        s = "";
//        s = "dvdf";
//        s = "abbab";
//        s = "ohomm";
//        s = "tmmzuxt";
//        s = "abcdef";
        int i = lengthOfLongestSubstring(s);
        System.out.println("i = " + i);
        int j = lengthOfLongestSubstring2(s);
        System.out.println("j = " + j);

    }
}
