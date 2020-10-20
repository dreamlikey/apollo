package com.wdq.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * #51 困难
 * @author wudq
 * @date 2020/10/20
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 *
 * 示例：
 *
 * 输入：4
 * 输出：[
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 * 链接：https://leetcode-cn.com/problems/n-queens
 */
public class _51_n皇后 {

    int n;
    //棋盘
    int[][] board;
    List<String> temp;
    List<List<String>> res;
    /**
     * 回溯、递归
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        board = new int[n][n];
        res = new ArrayList<>(n);
        solve(0);
        return res;
    }

    /**
     * 回溯（dfs） + 递归
     *
     * ##### 判断逻辑
     *
     * 从上到下，从左往右的顺序枚举所有皇后的位置，并判断位置是否在其他皇后的攻击范围内
     *
     * 存在四种情况：
     * 1. 如果当前位置所在层，超过棋盘边界，表示找到一组皇后位置，返回上一层
     * 2. 如果不在攻击范围，往下一层
     * 3. 如果在攻击范围，向右枚举
     * 4. 如果在攻击范围，同时这一层全部位置枚举都已枚举，返回上一层
     *
     * ##### 两类操作
     *
     * 1. **前往下一层**
     *    标识皇后
     *    添加皇后攻击范围
     *
     * 2. **返回上一层**
     *    撤销皇后标识
     *    撤销皇后攻击范围
     */
    private void solve(int row) {
        if (row >= n) {
            //得到一个正确的解
            res.add(new ArrayList<>(temp));
            return;
        }
        if (row == 0)
            temp = new ArrayList<>(n);

        for (int col = 0; col < n; col++) {
            //在皇后的攻击范围内，尝试其它位置
            if (!checkRange(row, col)) {
                continue;
            }
            //不再皇后的攻击范围内，继续向下
            char[] arrays = initArrays(n);
            arrays[col] = 'Q';
            temp.add(new String(arrays));
            //添加当前皇后的攻击范围
            addRange(row, col);
            solve(row+1);
            //返回上一层，撤销当前皇后的攻击范围
            revokeRange(row, col);
            //返回上一层，撤销当前位置皇后标识
            temp.remove(row);
        }
    }

    private char[] initArrays(int n) {
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = '.';
        }
        return chars;
    }

    /**
     * 检查是否在攻击范围内
     * @param row
     * @param col
     * @return
     */
    private boolean checkRange(int row, int col) {
        //大于0说明当前位置处在皇后攻击范围
        return  board[row][col] > 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    /**
     * 攻击范围
     * @param row   行
     * @param col   列
     */
    private void addRange(int row, int col) {
        //当前行、列加入攻击范围
        for (int i = 0; i < n; i++) {
            board[row][i] += 1;
            board[i][col] += 1;
        }
        //[row][col]位置计算了2次，所以-1
        board[row][col] -= 1;

        int add = row + col;
        int sub = row - col;

        //斜对角加入攻击范围
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //当两个数组元素的行坐标和列坐标，各自进行相减或相加所得的结果一样时，则它们在同一对角线上面
                if(i - j == sub || i + j == add) {
                    board[i][j] += 1;
                }
            }
        }
        //[row][col]位置计算了2次，所以-1
        board[row][col] -= 1;

    }

    /**
     * 撤销攻击范围
     * @param row
     * @param col
     */
    private void revokeRange(int row, int col) {
        //当前行、列加入攻击范围
        for (int i = 0; i < n; i++) {
            board[row][i] -= 1;
            board[i][col] -= 1;
        }
        //[row][col]位置计算了2次，所以+1
        board[row][col] += 1;

        int add = row + col;
        int sub = row - col;
        //斜对角加入攻击范围
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //当两个数组元素的行坐标和列坐标，各自进行相减或相加所得的结果一样时，则它们在同一对角线上面
                if(i - j == sub || i + j == add) {
                    board[i][j] -= 1;
                }
            }
        }
        //[row][col]位置计算了2次，所以+1
        board[row][col] += 1;
    }


    public static void main(String[] args) {
        _51_n皇后 o = new _51_n皇后();
        List<List<String>> lists = o.solveNQueens(8);
        System.out.println(lists);
    }
}
