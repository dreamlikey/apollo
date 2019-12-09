package com.wdq.pay;

import org.springframework.stereotype.Service;

/**
 * 微信支付
 */
@Service
public class WeChatPayProcessor extends AbstractPayProcessor{

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
        System.out.println("微信支付成功，支付参数：" + context.toString());
        return true;
    }

    @Override
    public String getChannel() {
        return PayChannelEnum.WECHAT_PAY.getChannel();
    }
}
