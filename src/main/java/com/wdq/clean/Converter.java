package com.wdq.clean;

/**
 * @author wudq
 * @date 2019/12/10
 */
public interface Converter<T,R> {

    T doForward(R r);

    R doBackward(T t);
}
