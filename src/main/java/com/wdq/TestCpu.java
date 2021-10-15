package com.wdq;

import com.alibaba.fastjson.JSONArray;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wudq
 * @date 2020/1/9
 */
public class TestCpu {
    private static ReentrantLock lock = new ReentrantLock(true);
    public static void main(String[] args) {
//        while (true) {
//            System.out.println(new Random().nextInt(200000));
//        }
        JSONArray jsonArray = new JSONArray();
        List<Integer> list = jsonArray.toJavaList(Integer.class);
        Collections.sort(list);

        List<Integer> list1 = Arrays.asList(3,1,2,4);
        Collections.sort(list1);
        List<Integer> list2 = Arrays.asList(1,2,3,4);

        System.out.println(list1.equals(list2));
    }
}
