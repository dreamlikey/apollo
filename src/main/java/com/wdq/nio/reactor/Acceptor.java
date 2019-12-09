package com.wdq.nio.reactor;

/**
 * 事件接收器<br/>
 * 负责初始化selector和接收缓冲队列
 * @author wudq
 * @date 2019/12/9
 */
public class Acceptor {
    Selector selector;

    public Acceptor(Selector selector) {
        this.selector = selector;
    }

    public void run() {

    }

    public void accept(Event event) {
        selector.addEvent(event);
    }
}
