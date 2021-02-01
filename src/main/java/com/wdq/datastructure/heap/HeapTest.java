package com.wdq.datastructure.heap;

import com.wdq.datastructure.utils.Integers;
import org.springframework.util.StopWatch;

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

        Integer[] array1 = Integers.random(100000,1, 30000);
        Integer[] array2 = Integers.copy(array1);
        StopWatch sw = new StopWatch();
        sw.start("topk");
        //最大top个
        TopK topK = new TopK();
        topK.top(array1, 100);
        sw.stop();
        Integer[] tops = topK.tops;
        Integers.println(tops);

        sw.start("botk");
        //最小top个
        BotK botK = new BotK();
        botK.bottom(array2, 100);
        sw.stop();
        System.out.println("botK = " + sw.prettyPrint());
        Integer[] bottoms = botK.tops;
        Integers.println(bottoms);
    }
}
