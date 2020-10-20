package com.wdq.algorithm.leetcode;


import com.wdq.datastructure.utils.Integers;

/**
 * @author wudq
 * kmp字符串匹配算法
 *  1/求解前缀表
 *  2/依据前缀表匹配
 */
public class KmpStringMatch {

    public static void main(String[] args) {
        String str = "ABABABABCABAAB";
        String strPattern = "ABABCABAA";
        char[] chars = strPattern.toCharArray();
        Integer[] prefixTable = prefixTable(chars);

        movePrefixTable(prefixTable);
        Integers.println(prefixTable);
        search(str, chars, prefixTable);
    }

    /**
     * 前缀表
     * @param pattern
     * @return
     */
    public static Integer[] prefixTable(char[] pattern) {
        int len = 0;
        int i   = 1;
        int n = pattern.length;
        Integer[] prefix = new Integer[n];
        prefix[0] = 0;
        while (i < n) {
            //当前字符 与 前一个字符的【前缀表】下标所对应的元素相同
            if (pattern[i] == pattern[len]) {
                len++;
                prefix[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = prefix[len - 1];
                } else {
                    prefix[i] = 0;
                    i++;
                }
            }

        }
        return prefix;
    }

    /**
     * 0位置赋值-1
     * @param prefixTable
     */
    public static void movePrefixTable(Integer[] prefixTable) {
        for (int i = prefixTable.length - 1; i >0 ; i--) {
            prefixTable[i] = prefixTable[i-1];
        }
        prefixTable[0] = -1;
    }

    /**
     *  pattern.len  = n
     *  str.len      = m
     * @param str
     * @param pattern
     * @param prefixTable
     */
    public static void search(String str, char[] pattern, Integer[] prefixTable) {
        int m = str.length(), i = 0;
        int n = pattern.length, j = 0;
        while (i < m) {
            //System.out.println("i:"+i + " j:"+j);
            //字符相同 比较下一个
            if (str.charAt(i) == pattern[j]) {
                //如果已经比较到了最后一个字符，输出匹配的串位置，并将匹配串移动到0重新开始匹配
                if (j == n - 1) {
                    System.out.println("find match str at index : " + (i-j));
                    j = -1;
                }
                i++;
                j++;
            }else {//字符不同，移动到公共前缀的位置 进行比较
                //如果j的下标为-1，比较下一个元素
                if (prefixTable[j] == -1){
                    i++;
                    j = 0;
                } else {
                    j = prefixTable[j];
                }
            }
        }
    }

}
