package com.wdq.effective;

/**
 * @author wudq
 * @date 2020/4/7 0007
 * @Description: TODO
 */
public class Effec7 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(sum2());
        long end = System.currentTimeMillis();
        System.out.println("耗时："+ (end - start));
    }
//    7629
    private static long sum() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++){
            sum += i;
        }
        return sum;

    }
//    837
    private static long sum2() {
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++){
            sum += i;
        }
        return sum;

    }
}
