package com.wdq.nio.reactor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 事件分发器（事件分离器）<br/>
 * 事件的注册、删除和分发
 * @author wudq
 * @date 2019/12/9
 */
public class Dispatcher {
    /**
     * 事件类型与处理器映射关系
     */
    Map<EventType, Handler> eventHandlerMap = new ConcurrentHashMap<>();

    Selector selector;

    public Dispatcher(Selector selector) {
        this.selector = selector;
    }

    public void register(EventType type, Handler handler) {
        eventHandlerMap.put(type, handler);
    }

    public void remove(EventType type) {
        eventHandlerMap.remove(type);
    }

    /**
     * 事件分发给相应处理器
     */
    public void dispatch() {
        while (true) {
            List<Event> events = selector.select();
            for (Event event : events) {
                eventHandlerMap.get(event.getType()).handle(event);
            }
        }
    }
}
