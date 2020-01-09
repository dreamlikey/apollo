package com.wdq.pattern.reactor;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 事件监听
 * @author wudq
 * @date 2019/12/19
 */
public class Selector {

    private BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<>();

    public List<Event> select() {
        List<Event> events = new ArrayList<>();
        eventQueue.drainTo(events);
        return events;
    }

    public void add(Event event) {
        eventQueue.offer(event);
    }

}
