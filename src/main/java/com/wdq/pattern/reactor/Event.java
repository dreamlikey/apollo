package com.wdq.pattern.reactor;

/**
 * 事件
 * @author wudq
 * @date 2019/12/19
 */
public class Event {
    private EventType type;

    public Event(EventType type) {
        this.type = type;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }
}
