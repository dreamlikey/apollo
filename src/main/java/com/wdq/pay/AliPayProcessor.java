package com.wdq.pay;

import org.springframework.stereotype.Service;

/**
 * 支付宝
 */
@Service
public class AliPayProcessor extends AbstractPayProcessor{

    @Override
    public boolean preCheckedContext(PayContext context) {
        if (context.getCent() <= 0) {
            context.setMessage("支付参数错误");
            return false;
        }
        return true;
    }

    @Override
    public boolean doPay(PayContext context) {
        System.out.println("支付宝支付成功，支付参数：" + context.toString());
        context.setMessage("支付宝支付成功");
        return true;
    }

    @Override
    public String getChannel() {
        return PayChannelEnum.ALI_PAY.getChannel();
    }
}
