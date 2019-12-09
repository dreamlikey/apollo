package com.wdq.nio.reactor;

/**
 * 事件处理器
 * @author wudq
 * @date 2019/12/9
 */
public interface Handler {
    /**
     * 具体事件处理
     * @param event
     */
    void handle(Event event);
}
