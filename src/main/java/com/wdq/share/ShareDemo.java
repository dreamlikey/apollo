package com.wdq.share;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wudq
 * @date 2019/1/24
 * @Description: TODO
 */
@Configuration
@ComponentScan("com.wdq.share")
public class ShareDemo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ShareDemo.class);
                ShareProcessor shareProcessor = new QQShare();
        String token = "WUDQ";
                shareProcessor.processor(token);

        ShareProcessor.shareChannelMap.get(ShareChanelEnum.QQ).processor(token);

    }
}
