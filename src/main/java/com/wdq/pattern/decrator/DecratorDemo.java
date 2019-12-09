package com.wdq.pattern.decrator;

/**
 * @author wudq
 * @date 2019/1/30
 * @Description: TODO
 */
public class DecratorDemo {
    public static void main(String[] args) {
        Decorator decorator = new ConcreteDecoratorA(new ConcreteComponentB());
        decorator.add("elm");
    }
}
