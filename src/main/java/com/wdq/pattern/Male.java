package com.wdq.pattern;

/**
 * @author wudq
 * @date 2019/1/28
 * @Description: TODO
 */
public class Male extends Person {
    public Male() {
    }

    public Male(String name, Integer age) {
        super(name, age);
    }

    @Override
    public void setName(String name) {
        System.out.println("sdasd");
        super.setName(name);
    }
}
