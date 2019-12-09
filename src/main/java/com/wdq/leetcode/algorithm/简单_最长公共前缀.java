package com.wdq.leetcode.algorithm;

/**
 * @author wudq
 * @date 2019/8/14 001410
 * @Description:
 */
public class 简单_最长公共前缀 {
    public static void main(String[] args) {
        Solution_LongestCommonPrefix solution = new Solution_LongestCommonPrefix();
        String[] strs = {"flower","flow","flight"};
//        String[] strs1 = {"dog","racecar","car","do"};
        String[] strs2 = {"a"};
        String[] strs3 = {};
        System.out.println(solution.longestCommonPrefix(strs));
//        System.out.println(solution.longestCommonPrefix(strs1));
        System.out.println(solution.longestCommonPrefix(strs2));
    }


}


/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */
class Solution_LongestCommonPrefix {

    //依然很暴力
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        if (strs.length == 0) {
            return res;
        }
        int minStrLen = strs[0].length();
        int minStrIndex = 0;
        boolean flag = true;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() > minStrLen) {
                continue;
            }
            if (strs[i].length() < minStrLen ) {
                minStrLen =  strs[i].length();
                minStrIndex = i;
            }
        }
        for (int i = 0; i < minStrLen; i++) {
            if (!flag) {
                break;
            }
            for (int j = 0; j < strs.length; j++) {
                if (strs[minStrIndex].charAt(i) != strs[j].charAt(i)) {
                    flag = false;
                    break;
                }
                if (j == strs.length - 1) {
                    res = strs[minStrIndex].substring(0,i+1);
                }
            }
        }
        return res;
    }

    //分治法
    public String longestCommonPrefix_divide(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

}