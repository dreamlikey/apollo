package com.wdq.leetcode.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wudq
 * @date 2019/8/7
 * @Description:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class 中等_无重复字符的最长子串 {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
//        int len = solution.lengthOfLongestSubstring("pwwkew");
        int len = solution.lengthOfLongestSubstring("tmmzuxtazsdd");
//        int len = solution.lengthOfLongestSubstring("abb");
        System.out.println(len);
    }
}

/**
 * 解题：
 * 1、滑动窗口
 * 滑动窗口是数组/字符串问题中常用的抽象概念。
 * 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，
 * 即 [i, j)[i,j)（左闭，右开）。而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。
 * 例如，我们将 [i,j)[i,j) 向右滑动 11 个元素，
 * 则它将变为 [i+1, j+1)[i+1,j+1)（左闭，右开）。
 *
 */
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        int maxLen = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            maxLen = Math.max(maxLen,i-left+1);
        }
        return maxLen;
    }
}