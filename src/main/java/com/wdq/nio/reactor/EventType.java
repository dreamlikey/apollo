package com.wdq.nio.reactor;

/**
 * 事件类型
 * @author wudq
 * @date 2019/12/9
 */
public enum EventType {
    ACCEPT(1),
    READ(2),
    WRITE(3);

    public int type;

    EventType(int type) {
        this.type = type;
    }
}
