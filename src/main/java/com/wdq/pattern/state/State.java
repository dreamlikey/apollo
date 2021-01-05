package com.wdq.pattern.state;

/**
 *
 * 状态类，包含动作声明
 * @author wudq
 * @date 2019/12/16
 */
public abstract class State {

    /**
     * 投币
     */
    public abstract void insertCoin();

    /**
     * 退币
     */
    public abstract void ejectCoin();

    /**
     * 转动出糖曲轴
     */
    public abstract void turnCrank();

    /**
     * 发糖
     */
    public abstract void dispense();

    /**
     * 退还硬币
     */
    protected void returnCoin() {
        System.out.println("退币……");
    }
}
