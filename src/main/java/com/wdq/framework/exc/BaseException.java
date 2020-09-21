package com.wdq.framework.exc;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 *
 * @author wudq
 * @date 2020/09/09
 */
public class BaseException extends RuntimeException {

    protected ResultCode resultCode;

    public BaseException() {
        super(BaseCodes.FAILURE.getMessage());
        this.resultCode = BaseCodes.FAILURE;
    }

    public BaseException(String message) {
        super(message);
        this.resultCode = BaseCodes.FAILURE;
    }

}
