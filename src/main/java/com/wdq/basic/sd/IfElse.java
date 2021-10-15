package com.wdq.basic.sd;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 *
 * @author wudq
 * @date 2021/07/23
 */
public class IfElse {
    // 计算
    public int calculate(int a, int b, String operator) {
        int result = Integer.MIN_VALUE;

        if ("add".equals(operator)) {
            result = a + b;
        } else if ("multiply".equals(operator)) {
            result = a * b;
        } else if ("divide".equals(operator)) {
            result = a / b;
        } else if ("subtract".equals(operator)) {
            result = a - b;
        }
        return result;
    }


    public int calculateUsingSwitch(int a, int b, String operator) {
        int result = Integer.MIN_VALUE;
        switch (operator) {
            case "add":
                result = a + b;
                break;
            // other cases
        }
        return result;
    }



}
