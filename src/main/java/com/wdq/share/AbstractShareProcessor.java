package com.wdq.share;

import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

/**
 * @author wudq
 * @date 2019/1/24
 * @Description: TODO
 */
@Service
public abstract class AbstractShareProcessor implements ShareProcessor{

    @PostConstruct
    public void init() {
        shareChannelMap.put(this.getChannel(), this);
    }

    @Override
    public void processor(String token) {
        ShareContext shareContext = getShareContext(token);
        share(shareContext);
    }

    protected ShareContext getShareContext(String token) {
        ShareContext shareContext = new ShareContext();
        shareContext.setContent(this.getContent());
        shareContext.setTitle(this.getTitle());
        shareContext.setUrl(this.getUrl(token));
        return shareContext;
    }

    protected abstract String getTitle();

    protected abstract String getUrl(String token);

    protected abstract String getContent();

    protected abstract boolean share(ShareContext shareContext);

    protected abstract ShareChanelEnum getChannel();
}
