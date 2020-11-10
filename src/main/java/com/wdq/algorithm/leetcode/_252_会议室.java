package com.wdq.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author wudq
 * @date 2020/11/10
 */
public class _252_会议室 {

    public boolean canMetting(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return true;
        //开始时间重小到大排序
        Arrays.sort(intervals, (m1, m2) -> (m1[0] - m2[0]));
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] > intervals[i+1][0]) {
                return false;
            }
        }
        return true;
    }
}
