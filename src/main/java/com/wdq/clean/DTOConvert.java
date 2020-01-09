package com.wdq.clean;

/**
 * @author wudq
 * @date 2019/12/10 001010
 * @Description: TODO
 */
public interface DTOConvert<T,R> {
    T convert(R r);
}
