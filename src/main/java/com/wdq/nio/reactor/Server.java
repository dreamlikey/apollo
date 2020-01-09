package com.wdq.nio.reactor;

/**
 * 模拟服务端
 * @author wudq
 * @date 2019/12/9
 */
public class Server {
    Selector selector = new Selector();
    Acceptor acceptor = new Acceptor(selector);
    Dispatcher eventLoop = new Dispatcher(selector);

    public void start() {
        Handler handler = new AcceptEventHandler(selector);
        eventLoop.register(EventType.ACCEPT, handler);
    }
}
