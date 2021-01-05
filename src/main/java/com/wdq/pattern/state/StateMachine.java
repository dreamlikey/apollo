package com.wdq.pattern.state;

/**
 * @author wudq
 * @date 2019/12/13
 */
public class StateMachine {

    private static int SOLD_OUT = 0;
    //没有硬币
    private static int NO_COIN = 1;
    //有硬币
    private static int HAS_COIN = 2;
    //准备出售
    private static int SOLD = 3;

    int state = SOLD_OUT;
    int count = 0;

    public StateMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_COIN;
        }
    }

    //投币
    public void insertCoin() {
        if (state == SOLD_OUT) {
            System.out.println("卖完了！");
        } else if (state == NO_COIN) {
            state = HAS_COIN;
            System.out.println("投币成功！");
        } else if (state == HAS_COIN) {
            System.out.println("已经投过币了！");
        } else if (state == SOLD) {
            System.out.println("已转手柄，等待出货！");
        }
    }

    //退币
    public void ejectCoin() {
        if (state == SOLD_OUT) {
            System.out.println("已售罄，没投币，怎么退！");
        } else if (state == NO_COIN) {
            System.out.println("没投币，怎么退！");
        } else if (state == HAS_COIN) {
            System.out.println("已投币，正在退币！");
            state = NO_COIN;
        } else if (state == SOLD) {
            System.out.println("已转手柄，无法退币！");
        }
     }

     //拉手柄
    public void turnCrank() {
        if (state == SOLD_OUT) {
            System.out.println("已售罄，无法拉动手柄！");
        } else if (state == NO_COIN) {
            System.out.println("没投币，怎么退！");
        } else if (state == HAS_COIN) {
            System.out.println("已投币，正在退币！");
            state = SOLD;
        } else if (state == SOLD) {
            System.out.println("已转过手柄，等待出货！");
        }
    }

    //发放
    public void dispense() {
        if (state == SOLD_OUT) {
            System.out.println("已售罄！");
        } else if (state == NO_COIN) {
            System.out.println("请先投币！");
        } else if (state == HAS_COIN) {
            System.out.println("请先转动手柄！");
        } else if (state == SOLD) {
            count = count - 1;
            if (count >= 0) {
                state = count == 0 ? SOLD_OUT : NO_COIN;
                System.out.println("出售成功！");
            }
        }
    }

    public static void main(String[] args) {
        StateMachine stateMachine = new StateMachine(5);
        stateMachine.insertCoin();
        stateMachine.dispense();
        stateMachine.dispense();
        stateMachine.dispense();
        stateMachine.dispense();
        stateMachine.dispense();
//        for (int i =0; i<5; i++) {
//
//        }
    }
}
