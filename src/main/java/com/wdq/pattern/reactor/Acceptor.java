package com.wdq.pattern.reactor;

import java.util.ArrayList;
import java.util.List;

/**
 * 事件注册
 * @author wudq
 * @date 2019/12/19
 */
public class Acceptor {

    Selector selector;

    public Acceptor(Selector selector) {
        this.selector = selector;
    }

    public void accept(Event event) {
        selector.add(event);
    }

}
