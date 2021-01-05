package com.wdq.pattern.state;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 * 没有硬币
 * @author wudq
 * @date 2021/01/05
 */
public class NoCoinState extends State {

    GumballMachine gumballMachine;

    public NoCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    /**
     * 投币
     */
    @Override
    public void insertCoin() {
        System.out.println("投币成功！");
        gumballMachine.setState(gumballMachine.hasCoin);
    }

    /**
     * 退币
     */
    @Override
    public void ejectCoin() {
        System.out.println("没有投币！");
    }

    /**
     * 转动出糖曲轴
     */
    @Override
    public void turnCrank() {
        System.out.println("请先投币！");
    }

    /**
     * 发糖
     */
    @Override
    public void dispense() {
        System.out.println("请先投币！");
    }
}
