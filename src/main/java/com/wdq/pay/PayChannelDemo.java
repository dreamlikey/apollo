package com.wdq.pay;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.wdq.pay")
public class PayChannelDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PayChannelDemo.class);
        PayContext context = new PayContext(1000, null);
        PayProcessor.payChannelMap.get(PayChannelEnum.ALI_PAY.getChannel()).processor(context);
        System.out.println(context.getMessage());
    }


}
