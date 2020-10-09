package com.wdq.framework.exc;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 *
 * @author wudq
 * @date 2020/09/09
 */
public interface ApolloAssert extends ResultCode, Assert {
    @Override
    default BaseException newException() {
        throw new ApolloException();
    }

    @Override
    default BaseException newException(String message) {
        throw new ApolloException(message);
    }
}
