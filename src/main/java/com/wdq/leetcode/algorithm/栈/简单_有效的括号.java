package com.wdq.leetcode.algorithm.栈;

/**
 * @author wudq
 * @date 2019/8/14 001411
 * @Description: TODO
 */
public class 简单_有效的括号 {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf("{"));
    }
}

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 */
class Solution_isValid {
    public boolean isValid(String s) {
        char[] chars = new char[s.length()];
        if (s.length()%2 == 1) {
            return false;
        }
        for (int i =0; i < s.length(); i++) {

        }
        return false;
    }
}