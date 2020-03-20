package com.wdq.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 延时队列
 * 1、环形队列
 * 2、
 * @author wudq
 * @date 2020/3/16
 */
public class DelayQueue {

    private static int queueSize = 60;

    static List<Slot> cycleQueue = new ArrayList<Slot>(queueSize);

    /**
     * @param key
     * @param delayTime 延迟时间 秒数
     */
    public void add(String key,int delayTime) {
        //计算队列位置
        int index = (delayTime + getIndex()) % queueSize;

        //任务
        Task task = new Task();
        int cycleNum = delayTime/queueSize;
        task.setCycleNum(cycleNum);
        task.setKey(key);

        //凹槽
        Slot slot = cycleQueue.get(index);
        Set<Task> set = slot.getTaskSet();
        set.add(task);
        //没有任务集则添加
        if (slot == null) {
            slot = new Slot();
            cycleQueue.add(index,slot);
        }
        System.out.println("添加task:"+index);
    }

    public Task offer() {
        int index = getIndex();
        System.out.println("当前位置："+index);

        Slot slot = null;
        try {
            slot = cycleQueue.get(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (slot == null) {
            return null;
        }
        Set<Task> tasks = slot.getTaskSet();
        Iterator<Task> iter = tasks.iterator();
        Task task;
        while (iter.hasNext()) {
            task = iter.next();
            int cycleNum = task.getCycleNum() -1;
            task.setCycleNum(cycleNum);
            if (cycleNum <= 0 ) {
                return task;
            }
        }
        return null;
    }

    public static int getIndex() {
        long totalMilliSeconds = System.currentTimeMillis();
        long totalSeconds = totalMilliSeconds / 1000;
        return (int) (totalSeconds%queueSize);
    }
}



class Slot {
    Set<Task> taskSet = new HashSet<>();

    public Set<Task> getTaskSet() {
        return taskSet;
    }

    public void setTaskSet(Set<Task> taskSet) {
        this.taskSet = taskSet;
    }
}

class Task {
    //任务被执行所要经历的圈数
    int cycleNum = 0;
    String taskType;
    String key;

    public int getCycleNum() {
        return cycleNum;
    }

    public void setCycleNum(int cycleNum) {
        this.cycleNum = cycleNum;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
