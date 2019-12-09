package com.wdq.apollo.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApolloConfig {

//    @Value("${jdbc.master.url}")
    private String url;

    public String getUrl() {
        return url;
    }
}

