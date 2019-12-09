package com.wdq.nio.reactor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 事件监控器（事件同步分离器）<br/>
 * 同步阻塞等待事件发生，当检测到新事件发生时，通知事件分发器，回调特定的事件处理器
 * @author wudq
 * @date 2019/12/9
 */
public class Selector {

    private BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<>();

    public List<Event> select() {
        List<Event> eventList = new ArrayList<>();
        eventQueue.drainTo(eventList);
        return eventList;
    }

    public void addEvent(Event event) {
        eventQueue.offer(event);
    }
}
