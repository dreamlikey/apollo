package com.wdq.share;

/**
 * @author wudq
 * @date 2019/1/24
 * @Description: TODO
 */
public enum ShareChanelEnum {
    QQ("QQ","qq分享"),
    WECHAR("WECHAR","微信分享"),
    SINA("SINA","新浪微博")
    ;

    ShareChanelEnum(String channel, String desc) {
        this.channel = channel;
        this.desc = desc;
    }

    private String channel;

    private String desc;

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
