package com.wdq.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wudq
 * @date 2019/8/9 000916
 * @Description: TODO
 */
public class Z字头变换 {
    public static void main(String[] args) {
        System.out.println("LEETCODEISHIRING".length());
    }
}

/**
 * 方法一：按行排序
 * 思路
 *
 * 通过从左向右迭代字符串，我们可以轻松地确定字符位于 Z 字形图案中的哪一行。
 *
 * 算法
 *
 * 我们可以使用 min(numRows,len(s)) 个列表来表示 Z 字形图案中的非空行。
 *
 * 从左到右迭代 ss，将每个字符添加到合适的行。可以使用当前行和当前方向这两个变量对合适的行进行跟踪。
 *
 * 只有当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变。
 *
 */
class Solution5 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        return null;
    }
}
