package com.wdq.framework.exc;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 *
 * @author wudq
 * @date 2020/09/09
 */
@Getter
@Setter
public abstract class Result {
    /** CODE */
    public static final String CODE = "code";
    /** SUCCESS */
    public static final String SUCCESS = "success";
    /** DATA */
    public static final String DATA = "data";
    /** MESSAGE */
    public static final String MESSAGE = "message";

    /** 请求成功代码 */
    public static final String SUCCESS_CODE = "2000";

    /** 默认的失败代码 */
    public static final String FAILURE_CODE = "4000";
    public static final String FAILURE_MESSAGE = "请求失败";
}
