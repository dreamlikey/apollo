package com.wdq.nio;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * 用于统计的ForkJoinTask
 */
public class CountTask extends RecursiveTask<Integer> {

    private static final int THREAD_HOLD = 2;

    private int start;
    private int end;

    public CountTask(int start,int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        //如果任务足够小就计算
        boolean canCompute = (end - start) <= THREAD_HOLD;
        if(canCompute){
            for(int i=start;i<=end;i++){
                sum += i;
            }
        }else{
            int middle = (start + end) / 2;
            CountTask left = new CountTask(start,middle);
            CountTask right = new CountTask(middle+1,end);
            //执行子任务
            left.fork();
            right.fork();
            //获取子任务结果
            int lResult = left.join();
            int rResult = right.join();
            sum = lResult + rResult;
        }
        return sum;
    }

    public static void main(String[] args){
        long start = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        CountTask task = new CountTask(1,4);
        Future<Integer> result = pool.submit(task);
        long end = System.currentTimeMillis();
        try {
            System.out.println(result.get() + " 耗时："+(end-start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
