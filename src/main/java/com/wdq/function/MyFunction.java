package com.wdq.function;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 *
 * @author wudq
 * @date 2021/12/06
 */
@FunctionalInterface
public interface MyFunction<T, T1, R> {
    R apply(T t1, T1 t2);
}
