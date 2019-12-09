package com.wdq.pay;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * 支付处理模板
 *  具体的支付渠道继承模板，重写模板的方法实现各自支付逻辑
 * wudq 2018/12/10
 */
@Service
public abstract class AbstractPayProcessor implements PayProcessor{

    /**
     * 初始化支付通道
     * spring容器启动时，调用init保存支付渠道到Map
     */
    @PostConstruct
    public  void init() {
        payChannelMap.put(this.getChannel(), this);
    }

    @Override
    public boolean processor(PayContext context) {

        if (!preCheckedContext(context)) {
            return false;
        }
        doPay(context);
        return true;
    }

    /**
     * 支付参数检查
     * @param context
     * @return
     */
    public abstract boolean preCheckedContext(PayContext context);

    /**
     * 支付
     * @param context
     * @return
     */
    public abstract boolean doPay(PayContext context);

    /**
     * 或取当前支付通道
     * @return
     */
    public abstract String getChannel();
}
