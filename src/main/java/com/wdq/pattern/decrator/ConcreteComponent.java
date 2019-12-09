package com.wdq.pattern.decrator;

/**
 * @author wudq
 * @date 2019/1/30
 * @Description: 具体组件实现
 */
public class ConcreteComponent implements Component{

    @Override
    public void add(String element) {
        System.out.println("实现A成功添加一个元素！");
    }
}
