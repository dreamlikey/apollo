package com.wdq.basic;

/**
 * @author wudq
 * @date 2019/7/11
 * @Description: TODO
 */

//1、2说明只要try有异常，一定会执行catch，如果finally有返回,一定从finally返回
//3说明只要try没有异常，一定不执行catch
//4说明只要try没有异常，在try里返回数据且finally处没有返回，则finally没有改变try返回的数据
//5说明只要try没有异常，在try里不返回数据且finally处没有返回，则finally改变了try里面的数据
public class TryCatchFinally {

    public static final String test() {
        String t = "";
        try {
            int i = 1/0;
            t = "try";
            return t;
        } catch (Exception e) {
            // result = "catch";
            e.printStackTrace();
            t = "catch";
        } finally {
            t = "finally";
            return t;
        }
    }

    public static void main(String[] args) {
        System.out.print(TryCatchFinally.test());
    }
}
