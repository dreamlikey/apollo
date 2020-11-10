package com.wdq.algorithm.leetcode;

/**
 * @author wudq
 * @date 2020/11/10
 *
 * 需要的最少会议室
 *
 * 排序 + 小顶堆
 * 小顶堆存放会议的结束时间，
 * 如果下个会议的开始时间 小于 堆顶则需要新开会议室
 * 如果 大于，则将当前会议的结束时间替换堆顶并下沉（shiftdown）
 */
public class _253_会议室2 {
    public int minMeetingRooms(int[][] intervals) {
        return 0;
    }
}
