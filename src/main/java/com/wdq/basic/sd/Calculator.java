package com.wdq.basic.sd;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 *
 * @author wudq
 * @date 2021/08/04
 */
public class Calculator {

    public int calculate(Command command) {
        return command.execute();
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int calculate = calculator.calculate(new AddCommand(1, 2));
        System.out.println("calculate = " + calculate);

        calculate = calculator.calculate(new MultiplyCommand(1, 2));
        System.out.println("calculate = " + calculate);
    }

}
