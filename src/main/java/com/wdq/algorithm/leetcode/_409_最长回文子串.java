package com.wdq.algorithm.leetcode;

/**
 * @author wudq
 * @date 2020/10/19
 */
public class _409_最长回文子串 {

    public static int longestPalindrome(String s) {
        if (s == null)
            return 0;
        int[] nums = new int['z'-'A' + 1];
        char[] chars = s.toCharArray();
        int len = 0;
        for (int i = 0; i < chars.length; i++) {
            if ( nums[chars[i] - 65] == 1) {
                nums[chars[i] - 65] = 0;
                len+=2;
            } else if (nums[chars[i] - 65] == 0){
                nums[chars[i] - 65] = 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                len++;
                break;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int a = 'A';
        System.out.println("a = " + a);
        String s = "zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez";
        int i = longestPalindrome(s);
        System.out.println("i = " + i);
    }
}
