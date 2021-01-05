package com.wdq.pattern.state;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 * 售罄
 * @author wudq
 * @date 2021/01/05
 */
public class SoldOutState extends State {

    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    /**
     * 投币
     */
    @Override
    public void insertCoin() {
        System.out.println("糖果已经售尽");
    }

    /**
     * 退币
     */
    @Override
    public void ejectCoin() {
        System.out.println("没有投币，无法退币");
    }

    /**
     * 转动出糖曲轴
     */
    @Override
    public void turnCrank() {
        System.out.println("糖果已经售尽");
    }

    /**
     * 发糖
     */
    @Override
    public void dispense() {
        System.out.println("糖果已经售尽");
    }
}
