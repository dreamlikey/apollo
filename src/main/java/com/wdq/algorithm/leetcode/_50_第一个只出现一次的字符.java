package com.wdq.algorithm.leetcode;

/**
 * @author wudq
 * @date 2020/10/18
 */
public class _50_第一个只出现一次的字符 {


    //小写字母（a-z）：97（a） ~ 122（z）

    /**
     * 计算排序
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        if (chars == null) {
            return ' ';
        }
        char[] resChars = new char[26];

        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 97;
            resChars[index] += 1;
        }

        for (int i = 0; i < chars.length; i++) {
            int index = chars[i]-97;
            int count = resChars[index];
            if (count == 1) {
                return chars[i];
            }
        }
        return ' ';
    }
}
