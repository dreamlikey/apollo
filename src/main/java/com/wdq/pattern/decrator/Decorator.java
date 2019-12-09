package com.wdq.pattern.decrator;

/**
 * @author wudq
 * @date 2019/1/30
 *
 * 装饰器
 */
public class Decorator implements Component{

    public Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void add(String element) {
        this.component.add(element);
    }
}
