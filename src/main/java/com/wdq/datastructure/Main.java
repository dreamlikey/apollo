package com.wdq.datastructure;


import com.wdq.datastructure.sort.*;
import com.wdq.datastructure.utils.Integers;

/**
 * https://www.cnblogs.com/onepixel/articles/7674659.html
 * @author wudq
 */
public class Main {
    public static void main(String[] args) {
        Integer[] array1 = Integers.random(10000, 1, 20000);
        Integer[] array2 = Integers.copy(array1);
        Integer[] array3 = Integers.copy(array1);
        Integer[] array4 = Integers.copy(array1);
        Integer[] array5 = Integers.copy(array1);
        Integer[] array6 = Integers.copy(array1);

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array1);
        System.out.println(Integers.isAscOrder(array1));
        System.out.println(bubbleSort);

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(array2);
        System.out.println(Integers.isAscOrder(array2));
        System.out.println(insertionSort);

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array3);
        System.out.println(Integers.isAscOrder(array3));
        System.out.println(mergeSort);

        QuickSort quickSort = new QuickSort();
        quickSort.sort(array4);
        System.out.println(Integers.isAscOrder(array4));
        System.out.println(quickSort);

        QuickSort quickSort2 = new QuickSort();
        quickSort2.sort(array5);
        System.out.println(Integers.isAscOrder(array5));
        System.out.println(quickSort2);

        HeapSort heapSort = new HeapSort();
        heapSort.sort(array6);
        System.out.println(Integers.isAscOrder(array6));
        System.out.println(heapSort);

        //System.out.println(Arrays.toString(array2));
    }
}
