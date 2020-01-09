package com.wdq.pattern.reactor;

import lombok.Data;

/**
 * @author wudq
 * @date 2019/12/19
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
