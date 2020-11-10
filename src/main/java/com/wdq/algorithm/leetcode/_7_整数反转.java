package com.wdq.algorithm.leetcode;

/**
 * @author wudq
 * @date 2020/11/10
 */
public class _7_整数反转 {
    public static int reverse(int x) {
        String numStr = String.valueOf(x);
        char[] chars = numStr.toCharArray();
        char[] nums =  new char[chars.length];

        if (chars[0] == '-' ) {
            nums[0] = chars[0];
        } else {
            nums[0] = chars[chars.length - 1];
        }
        for (int i = chars.length - 1; i > 0; i--) {
            nums[chars.length - i] = chars[i];
        }
        String s = new String(nums);
        int reverse = Integer.parseInt(s);
        //todo 判断溢出

        return Integer.parseInt(s);
    }

    public static int reverse2 (int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x%10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
                return 0;
            x /= 10;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        int x = 123232;
        int reverse = reverse2(x);
        System.out.println("reverse = " + reverse);
    }
}
