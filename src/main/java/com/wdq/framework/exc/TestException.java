package com.wdq.framework.exc;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 *
 * @author wudq
 * @date 2020/09/09
 */
public class TestException {
    public static void main(String[] args) {
        ApolloExcCodes.REQUEST_ERROR.newException();
    }
}
