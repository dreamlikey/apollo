package com.wdq.pay;

/**
 * 支付上下文
 * 封装支付参数以及支付返回状态
 */
public class PayContext {
    private int cent;

    private String message;

    public PayContext(int cent, String message) {
        this.cent = cent;
        this.message = message;
    }

    public int getCent() {
        return cent;
    }

    public void setCent(int cent) {
        this.cent = cent;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PayContext{" +
            "cent=" + cent +
            '}';
    }
}
