package com.wdq.nio.reactor;

/**
 * 事件处理器
 * @author wudq
 * @date 2019/12/9
 */
public abstract class EventHandler implements Handler {

    @Override
    public abstract void handle(Event event);

}
