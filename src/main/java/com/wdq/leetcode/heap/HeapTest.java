package com.wdq.leetcode.heap;

import com.wdq.leetcode.utils.Integers;

/**
 * 堆测试
 * @author wudq
 * @date 2020/10/10
 */
public class HeapTest {
    public static void main(String[] args) {
        Integer[] arrays = new Integer[]{1,3,4,5,7,6,2,8,0,9};
//        Heap heap = new MinHeap(arrays);
//        System.out.println();
//        heap.buildHeap();
////        heap.sort();
//        System.out.println("堆数组");
//        for (int i = 0; i < arrays.length; i++) {
//            System.out.print(arrays[i]);
//        }

        Integer[] array1 = Integers.random(10000,1, 30000);
        Integer[] array2 = Integers.copy(array1);

        //最大top个
        TopK topK = new TopK();
        topK.top(array1, 100);
        Integer[] tops = topK.tops;
        Integers.println(tops);

        //最小top个
        BotK botK = new BotK();
        botK.bottom(array2, 100);
        Integer[] bottoms = botK.tops;
        Integers.println(bottoms);
    }
}
