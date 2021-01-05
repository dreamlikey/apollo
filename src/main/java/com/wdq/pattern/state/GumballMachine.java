package com.wdq.pattern.state;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 *
 * @author wudq
 * @date 2021/01/05
 */
public class GumballMachine extends State {
    //已投币
    State hasCoin;
    //未投币
    State noCoin;
    //售罄
    State soldOut;
    //售出
    State sold;

    private State state = soldOut;
    private int candyCount = 0;

    public GumballMachine(int count) {
        hasCoin = new HasCoinState(this);
        noCoin = new NoCoinState(this);
        soldOut = new SoldOutState(this);
        sold = new SoldState(this);

        this.candyCount = count;
        if(count > 0)
            setState(noCoin);
    }

    /**
     * 投币
     */
    @Override
    public void insertCoin() {
        state.insertCoin();
    }

    /**
     * 退币
     */
    @Override
    public void ejectCoin() {
        state.ejectCoin();
    }

    @Override
    public void turnCrank() {
        state.turnCrank();
    }

    @Override
    public void dispense() {
        state.dispense();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setCandyCount(int candyCount) {
        this.candyCount = candyCount;
    }

    public int getCandyCount() {
        return candyCount;
    }

    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(100);
        gumballMachine.insertCoin();
        gumballMachine.turnCrank();
        gumballMachine.ejectCoin();
        gumballMachine.dispense();
    }
}
