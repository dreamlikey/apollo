package com.wdq.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * #51 困难
 * @author wudq
 * @date 2020/10/20
 *
 * 使用二维数组记录皇后攻击范围性能差，因为每一次选择皇后都要将它的攻击范围加入到二维数组，<br/>
 * 每一次撤销皇后都要将它的攻击范围（棋盘上覆盖的的所有位置）从二维数组移除，对棋盘上的每个点进行记录和比较,时间复杂度O(n^2)
 *
 * 使用列、左对角、右对角数组分别存储是否在皇后的攻击范围，如果所在的列、左对角线、右对角线都为false表示当前位置可选将列、左对角线、右对角线数组对应的索引值赋值true，
 *
 * 对棋盘上列、对角线 一整队进行比较时间复杂度O(1)
 */
public class _51_n皇后_优化 {

    //列是否存在皇后
    boolean[] cols;
    //左上角到右下角的对角线是否存在皇后
    boolean[] leftTops;
    //右上角到左下角的对角线是否存在皇后
    boolean[] rightTops;
    List<String> temp;
    List<List<String>> res;
    /**
     * 回溯、递归
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>(n);
        cols = new boolean[n];
        leftTops = new boolean[(n << 1) - 1];
        rightTops = new boolean[leftTops.length];
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
        if (row >= cols.length) {
            //得到一个正确的解
            res.add(new ArrayList<>(temp));
            return;
        }
        if (row == 0)
            temp = new ArrayList<>(cols.length);

        for (int col = 0; col < cols.length; col++) {
            if (cols[col])
                continue;
            int li = row - col + cols.length - 1;
            if (leftTops[li])
                continue;
            int ri = row + col;
            if (rightTops[ri])
                continue;

            //不再皇后的攻击范围内，继续向下
            char[] arrays = initArrays(cols.length);
            arrays[col] = 'Q';
            temp.add(new String(arrays));
            //添加当前皇后的攻击范围
            cols[col] = true;
            leftTops[li] = true;
            rightTops[ri] = true;

            solve(row+1);

            //返回上一层，撤销当前皇后的攻击范围
            cols[col] = false;
            leftTops[li] = false;
            rightTops[ri] = false;

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



    public static void main(String[] args) {
        _51_n皇后_优化 o = new _51_n皇后_优化();
        List<List<String>> lists = o.solveNQueens(4);
        System.out.println(lists);
    }
}
