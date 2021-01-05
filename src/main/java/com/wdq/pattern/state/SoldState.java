package com.wdq.pattern.state;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 * 售出
 *
 * @author wudq
 * @date 2021/01/05
 */
public class SoldState extends State {

    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    /**
     * 投币
     */
    @Override
    public void insertCoin() {
        System.out.println("准备发糖，请勿重复投币");
    }

    /**
     * 退币
     */
    @Override
    public void ejectCoin() {
        System.out.println("无法退币，正在发放糖果，请等待");
    }

    /**
     * 转动出糖曲轴
     */
    @Override
    public void turnCrank() {
        System.out.println("准备发糖，请勿重复拉动曲轴");
    }

    /**
     * 发糖
     */
    @Override
    public void dispense() {
        int candyCount = gumballMachine.getCandyCount();
        if(candyCount > 0){
            System.out.println("分发一颗糖果");
            candyCount--;
            gumballMachine.setCandyCount(candyCount);
            if(candyCount > 0){
                gumballMachine.setState(gumballMachine.noCoin);
                return;
            }
        }

        System.out.println("抱歉，糖果已售尽");
        gumballMachine.setState(gumballMachine.soldOut);
    }
}
