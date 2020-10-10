package com.wdq.leetcode.sort;


/**
 * @author wudq
 * @date 2020/10/03
 * 快速排序
 */
public class QuickSort<E extends Comparable<E>> extends Sort<E>{
    @Override
    protected void sort() {
        sort(0, array.length);
    }

    private void sort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        int mid = pivot(begin, end);

        sort(begin, mid);
        sort(mid + 1, end);
    }

    /**
     * 找到中轴点
     * 大于      中轴点元素 放到右侧   交换比较方向到左侧
     * 小于等于  中轴点元素 的放左侧   交换比较方向到右侧
     * @param begin
     * @param end
     */
    private int pivot(int begin, int end) {
        //swap(begin, begin + (int)Math.random()*(end - begin));
        E pivot = array[begin];
        end--;
        //
        while(begin < end) {
            while (begin < end) {
                //右侧元素 > 中轴点  元素不变 end--
                if (cmp(pivot, array[end]) < 0) {
                    end--;
                } else { //右侧元素 <= 中轴点 end元素复制到begin，begin++
                    array[begin] = array[end];
                    begin++;
                    break;
                }
            }

            while(begin < end) {
                //左侧元素 <= 中轴点  元素不变 begin++
                if (cmp(pivot, array[begin]) > 0) {
                    begin++;
                } else {//左侧元素 > 中轴点 begin元素复制到end，end--
                    array[end] = array[begin];
                    end--;
                    break;
                }
            }
        }

        array[begin] = pivot;
        return begin;
    }
}
