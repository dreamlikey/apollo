package com.wdq.function;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 *
 * @author wudq
 * @date 2021/12/06
 */
public class Calculation {
    public static int add(Integer a, Integer b) {
        return a + b;
    }

    public static int sub(Integer a, Integer b) {
        return a - b;
    }

    public static void main(String[] args) {

        MyFunction<Integer, Integer, Integer> add = Calculation::add;
        MyFunction<Integer, Integer, Integer> sub = Calculation::sub;

        Map<String, MyFunction<Integer, Integer, Integer>> actionMap = new HashMap<>();
        actionMap.put("add", add);
        actionMap.put("sub", sub);

        System.out.println("actionMap = " + actionMap.get("add").apply(1, 2));
        System.out.println("actionMap = " + actionMap.get("sub").apply(1, 2));
    }
}
