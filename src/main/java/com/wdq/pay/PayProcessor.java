package com.wdq.pay;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 支付处理
 */
public interface PayProcessor {

    /**
     * 支付通道容器
     *  存放各支付渠道实例
     */
    static ConcurrentHashMap<String, PayProcessor> payChannelMap = new ConcurrentHashMap<>();

    /**
     * 支付处理（processor:加工）
     * @param context
     * @return
     */
    boolean processor(PayContext context);
}
