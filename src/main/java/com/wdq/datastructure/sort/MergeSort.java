package com.wdq.datastructure.sort;


/**
 * @author wudq
 * @date 2020/10/02
 * 归并排序
 * 不断将当前序列平均分割成两个子序列（直到不能再分割【序列中只有1一个子序列】）
 * 不断将两个子序列合并成一个有序 序列
 */
public class MergeSort<E extends Comparable<E>> extends Sort<E>{

    private Object[] tempArray;

    @Override
    public void sort() {
        tempArray = new Object[array.length >> 1];
        sort(0, array.length);
    }

    /**
     * 递归分割子序列 并 合并一个有序序列
     * @param begin
     * @param end
     */
    private void sort(int begin, int end) {
        //最少切割2个元素
        if (end - begin < 2) {
            return;
        }
        int mid = begin + end >> 1;

        sort(begin, mid);
        sort(mid, end);
        merge(begin, mid, end);
    }

    /**
     * merge
     * 分割成 左右 两个序列进行比较
     *
     * @param begin
     * @param mid
     * @param end
     */
    private void merge(int begin, int mid, int end) {
        int li = 0, le = mid - begin;
        int ri = mid, re = end;
        int ai = begin;

        // 备份左 序列
        for (int i = 0; i < le; i++) {
            tempArray[i] = array[begin + i];
        }
        /**
         * 合并
         * 小的元素放到 序列左边
         *
         */
        while (li < le) {
            if (ri < re && cmp(array[ri], (E) tempArray[li]) < 0) {
                array[ai++] = array[ri++];
            }else {
                array[ai++] = (E) tempArray[li++];
            }
        }
    }


}
