package com.wdq.share;

import org.springframework.stereotype.Service;

/**
 * @author wudq
 * @date 2019/1/24
 * @Description: TODO
 */
@Service
public class QQShare extends AbstractShareProcessor{

    @Override
    public String getTitle() {
        return "QQ分享";
    }

    @Override
    public String getUrl(String token) {
        return "www.qq.com";
    }

    @Override
    public String getContent() {
        return "QQ喊你爸回家吃饭了！";
    }

    @Override
    public boolean share(ShareContext shareContext) {
        System.out.println("成功分享到QQ，分享内容："+shareContext.toString());
        return true;
    }

    @Override
    protected ShareChanelEnum getChannel() {
        return ShareChanelEnum.QQ;
    }
}
