package com.wdq.nio.reactor;

/**
 * @author wudq
 * @date 2019/12/9
 */
public class AcceptEventHandler extends EventHandler{
    Selector selector;

    public AcceptEventHandler(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void handle(Event event) {
        //处理Accept事件
        if (event.getType() == EventType.ACCEPT) {
            System.out.println("---处理读取事件");
            //将事件状态改为下一个READ状态，并放入selector的缓冲队列中
            event.setType(EventType.READ);
            selector.addEvent(event);
        }
    }
}
