package com.wdq.apollo.spring;

import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApolloAnnotationBean {

//    @ApolloJsonValue("${jsonBeanProperty:[]}")
    private List<JsonBean> jsonBean;

//    @Value("${timeout:10}")
    private String timeout;

    public String getTimeout() {
        return timeout;
    }

    private static class JsonBean{
        private String someString;
        private int someInt;
    }
}
