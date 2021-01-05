package com.wdq.pattern.state;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 * 有硬币
 * @author wudq
 * @date 2021/01/05
 */
public class HasCoinState extends State {

    GumballMachine gumballMachine;

    public HasCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    /**
     * 投币
     */
    @Override
    public void insertCoin() {
        System.out.println("请不要重复投币！");
    }

    /**
     * 退币
     */
    @Override
    public void ejectCoin() {
        System.out.println("退币成功");
        gumballMachine.setState(gumballMachine.noCoin);
    }

    /**
     * 转动出糖曲轴
     */
    @Override
    public void turnCrank() {
        System.out.println("转动曲轴，准备发糖");
        gumballMachine.setState(gumballMachine.sold);
    }

    /**
     * 发糖
     */
    @Override
    public void dispense() {
        System.out.println("this method don't support");
    }
}
