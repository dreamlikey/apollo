package com.wdq.framework.exc;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author wudq
 * @date 2020/09/09
 */
@Getter
@AllArgsConstructor
public enum ApolloExcCodes implements ApolloAssert {
    REQUEST_ERROR(1001, "请求异常");
    private int code;
    private String message;
}
