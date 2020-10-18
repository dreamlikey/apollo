package com.wdq.leetcode.algorithm;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 *
 * @author wudq
 * @date 2020/10/13
 *
 */
public class _72_编辑距离 {

    public static void main(String[] args) {
//        String word1 = "horse", word2 = "ros";
        String word1 = "", word2 = "s";                 //zoologicoarc
//        String word1 = "zoologicoarchaeologist", word2 = "zoogeologist";
//        String word1 = "zoologico", word2 = "zoogeolog";
        int minDistance = minDistance(word1, word2);
        System.out.println("minDistance = " + minDistance);
    }

    /**
     * 动态规划求解
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null)
            return 0;
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        dp[0][0] = 0;
        //i行 0列
        for (int i = 1; i <= chars1.length; i++) {
            dp[i][0] = i;
        }

        //0行 i列
        for (int i = 1; i <= chars2.length; i++) {
            dp[0][i] = i;
        }

        int min, left, up, topLeft;
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                //从左边 编辑字符串 使得s1[0,i-1) == s2[0,j)，
                // 行字符数变化+1 列字符数不变， 这时需要插入或删除一个字符使得s1[0,i) == s2[0,j)
                //dp[i][j] = dp[i][j-1]+1
                left = dp[i][j-1] + 1;
                //从上面 编辑字符串 使得s1[0,i) == s2[0,j-1)，
                //列字符数变化+1 行字符数不变，这时需要插入或删除一个字符使得s1[0,i) == s2[0,j)
                //dp[i][j] = dp[i-1][j] + 1
                up = dp[i-1][j] + 1;
                //行列字符数都+1 不需要删除插入 使得字符相同 只需要替换操作，
                // 如果这两个位置的字符相同则不需要替换
                topLeft = dp[i-1][j-1];
                if (chars1[i-1] != chars2[j-1]) {
                    ++topLeft;
                }

                //左边值 与 上边值 比较
                min = Math.min(left, up);
                min = Math.min(min, topLeft);

                dp[i][j] = min;
            }
        }

        return dp[chars1.length][chars2.length];
    }

    public int minDistance2(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] minTable = new int[len1+1][len2+1];
        minTable[0][0] = 0;
        //i行 0列
        for (int i = 1; i < len1+1; i++) {
            minTable[i][0] = i;
        }
        //0行 i列
        for (int i = 1; i < len2+1; i++) {
            minTable[0][i] = i;
        }

        int min;
        for (int i = 1; i < len1+1; i++) {
            for (int j = 1; j < len2+1; j++) {
                //左边值 与 上边值 比较
                min = Math.min(minTable[i][j-1], minTable[i-1][j]);
                min = Math.min(min, minTable[i-1][j-1]);
                if (word1.charAt(i-1) != word2.charAt(j-1)) {
                    ++min;
                }
                minTable[i][j] = min;
            }
        }
        return minTable[len1][len2];
    }
}
