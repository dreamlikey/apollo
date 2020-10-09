package com.wdq.framework.exc;

import lombok.Data;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 *
 * @author wudq
 * @date 2020/09/09
 */

public interface ResultCode {
    String getMessage();

    int getCode();
}
