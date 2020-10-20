package com.wdq.datastructure.sort;

import java.text.DecimalFormat;

/**
 * @author wudq
 *
 */
public abstract class Sort<E extends Comparable<E>> implements Comparable<Sort<E>> {

    protected E[] array;
    private int cmpCount;
    private int swapCount;
    private int time;

    private DecimalFormat fmt = new DecimalFormat("#.00");

    /**
     * 排序
     */
    public void sort(E[] array) {
        long start = System.currentTimeMillis();
        this.array = array;
        if (array == null || array.length == 1) {
            return;
        }
        sort();
        time = (int) (System.currentTimeMillis() - start);
        toString();
    }

    /**
     *
     */
    protected abstract void sort();


    /**
     * 比较
     * 0 array[i1] == array[i2]
     * <0 array[i1] < array[i2]
     * 0> array[i1] > array[i2]
     * @param i1
     * @param i2
     * @return
     */
    protected int cmp(int i1, int i2) {
        cmpCount++;
        return array[i1].compareTo(array[i2]);
    }


    protected int cmp(E e1, E e2) {
        cmpCount++;
        return e1.compareTo(e2);
    }

    /**
     * 交换
     * @param i1
     * @param i2
     */
    protected void swap(int i1, int i2) {
        swapCount++;
        E temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    @Override
    public int compareTo(Sort o) {
        return compareTo(o);
    }

    @Override
    public String toString() {
        String timeStr = "耗时：" + (time / 1000.0) + "s(" + time + "ms)";
        String compareCountStr = "比较：" + numberString(cmpCount);
        String swapCountStr = "交换：" + numberString(swapCount);
        //String stableStr = "稳定性：" + isStable();
        return "【" + getClass().getSimpleName() + "】\n"
                //+ stableStr + " \t"
                + timeStr + " \t"
                + compareCountStr + "\t "
                + swapCountStr + "\n"
                + "------------------------------------------------------------------";
    }

    private String numberString(int number) {
        if (number < 10000) return "" + number;

        if (number < 100000000) return fmt.format(number / 10000.0) + "万";
        return fmt.format(number / 100000000.0) + "亿";
    }
}
