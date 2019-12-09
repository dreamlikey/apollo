package com.wdq.pattern.decrator;

/**
 * @author wudq
 * @date 2019/1/30
 * 具体的装饰
 */
public class ConcreteDecoratorB extends Decorator{
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void add(String element) {
        System.out.println("包装B");
        this.component.add(element);
    }
}
