package com.wdq.leetcode.algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author wudq
 * @date 2019/8/13 001317
 * @Description: TODO
 */
public class 中等_整数转罗马数字 {
    public static void main(String[] args) {
        Solution_intToRoman solution = new Solution_intToRoman();
        System.out.println(solution.intToRoman(1994));
        System.out.println(solution.romanToInt("MCMXCIV"));
        System.out.println(solution.romanToInt("YYY"));
    }
}

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9
 * 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 *
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 *
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 *
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * 1-3999
 */
class Solution_intToRoman {
    public String intToRoman(int num) {
        int res = 0;
        StringBuilder roman = new StringBuilder();
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;
        while (index < nums.length) {
            res = num / nums[index];
            num = num - res * nums[index];
            while (res>0) {
                roman.append(romans[index]);
                res--;
            }
            index++;
        }
        return roman.toString();
    }

    /**
     * 罗马转数字
     * 1、暴力破解法
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int res = 0;
        StringBuilder sb = new StringBuilder(s);
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;
        boolean flag = true;
        while (s.length() >0 && flag) {
            while (flag) {
                if (index >= romans.length) {
                    flag = false;
                    break;
                }
                if (s.startsWith(romans[index])) {
                    res += nums[index];
                    s = s.substring(romans[index].length());
                    break;
                }
                index++;
            }
        }

        return res;
    }
}