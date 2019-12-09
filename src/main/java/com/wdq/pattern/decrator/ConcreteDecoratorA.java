package com.wdq.pattern.decrator;

/**
 * @author wudq
 * @date 2019/1/30
 * 具体的装饰
 */
public class ConcreteDecoratorA extends Decorator{

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void add(String element) {
        System.out.println("包装A");
        this.component.add(element);
    }
}
