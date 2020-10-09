package com.wdq.framework.exc;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 *
 * @author wudq
 * @date 2020/09/09
 */
@Getter
@AllArgsConstructor
public enum BaseCodes implements BaseExceptionAssert {

    FAILURE(Integer.parseInt(Result.FAILURE_CODE), Result.FAILURE_MESSAGE);
    private int code;
    private String message;
}
