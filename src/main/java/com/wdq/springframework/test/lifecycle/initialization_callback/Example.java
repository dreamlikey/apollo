package com.wdq.springframework.test.lifecycle.initialization_callback;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author wudq
 * @date 2019/8/27
 * @Description: TODO
 */
@Component
public class Example {

    @PostConstruct
    public void init() {
        System.out.println("init");
        // do some initialization work
    }
}
