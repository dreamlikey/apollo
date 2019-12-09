package com.wdq.springframework.context;

import com.wdq.springframework.context.ApplicationContext;

/**
 * @author wudq
 * @date 2019/2/22 002214
 * @Description: TODO
 */
public class AbstractApplicationContext implements ApplicationContext {

    @Override
    public Object getBean(String beanName) {
        return null;
    }

    /**
     * 将上下文加载进spring容器
     */
    public void refresh() {

    }
}
