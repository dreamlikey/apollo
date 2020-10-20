package com.wdq.algorithm.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author wudq
 * @date 2020/10/18
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class _17_电话号码的字母组合 {
    char[][]  lettersArray = {{'a','b','c'},{'d','e','f'},{'g','h','i'},
                        {'j','k','l'},{'m','n','o'},{'p','q','r','s'},
                        {'t','u','v'},{'w','x','y','z'}};
    List<String> resList = new ArrayList<>();
    char[] chars;
    //记录遍历的字符，长度 = chars.length
    char[] numbers;

    /**
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        chars = digits.toCharArray();
        if (chars.length == 0) {
            return resList;
        }
        numbers = new char[chars.length];
        dfs(0);
        return resList;
    }


    /**
     * dfs : 深度优先搜索
     */
    private void dfs( int index) {
        //已经到最后一层
        if(index == chars.length) {
            //得到一个正确的解
            resList.add(new String(numbers));
            return;
        }

        //键盘数字
        char digit = chars[index];
        //键盘数字对应的字符数组
        char[] letters = lettersArray[digit - '2'];
        //遍历
        for (char letter : letters) {
            numbers[index] = letter;
            //深度遍历
            dfs(index+1);
        }
    }
}
