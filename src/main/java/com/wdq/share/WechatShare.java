package com.wdq.share;

import org.springframework.stereotype.Service;

/**
 * @author wudq
 * @date 2019/1/24
 * @Description: TODO
 */
@Service
public class WechatShare extends AbstractShareProcessor{

    @Override
    public String getTitle() {
        return "微信分享";
    }

    @Override
    public String getUrl(String token) {
        return "www.wechat.com?" + token;
    }

    @Override
    public String getContent() {
        return "微信喊你妈回家吃饭了！";
    }

    @Override
    public boolean share(ShareContext shareContext) {
        System.out.println("成功分享到微信，分享内容："+shareContext.toString());
        return true;
    }

    @Override
    protected ShareChanelEnum getChannel() {
        return ShareChanelEnum.WECHAR;
    }
}
