package com.wdq.basic;

/**
 * @author wudq
 * @date 2020/4/22 0022
 * @Description: TODO
 */
public class StringTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        test(sb);
        System.out.println("remark:" +sb.toString());

    }
    public static void test(StringBuilder sb) {
        sb = sb.append("sb");
    }
}
