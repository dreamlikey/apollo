package com.wdq.algorithm.leetcode;

/**
 * @author wudq
 * @date 2019/8/13
 * @Description:
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class 简单_整数反转 {
    public static void main(String[] args) {
        Solution7 solution = new Solution7();
        System.out.println(solution.reverse_2(-120));
        System.out.println(solution.reverse_2(321));
    }
}

class Solution7 {
    /**
     * 字符串反转
     * @param x
     * @return
     */
    public int reverse(int x) {
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        for (int i=str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '-') {
                sb.insert(0,'-');
                break;
            }
            sb.append(str.charAt(i));
        }
        return Integer.parseInt(sb.toString());
    }

    /**
     * 出栈入栈
     *
     * 出栈
     * int pop = x % 10;
     * x /= 10;
     *
     * 入栈
     * temp = rev * 10 + pop;
     * rev = temp;
     * ​
     *
     * @param x
     * @return
     */
    public int reverse_2(int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            //溢出返回0
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            res = res * 10 +pop;
        }
        return res;
    }
}
