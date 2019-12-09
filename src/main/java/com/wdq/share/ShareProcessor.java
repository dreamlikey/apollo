package com.wdq.share;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wudq
 * @date 2019/1/24 002421
 * @Description: 分享处理器
 */
public interface ShareProcessor {

    static ConcurrentHashMap<ShareChanelEnum, ShareProcessor> shareChannelMap = new ConcurrentHashMap<>();

    void processor(String token);
}
