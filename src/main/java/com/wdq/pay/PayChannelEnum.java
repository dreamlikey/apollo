package com.wdq.pay;

public enum PayChannelEnum {

    ALI_PAY("alipay","支付宝"),
    WECHAT_PAY("wechatpay","微信支付");

    private String channel;

    private String desc;

    PayChannelEnum(String channel, String desc) {
        this.channel = channel;
        this.desc = desc;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
