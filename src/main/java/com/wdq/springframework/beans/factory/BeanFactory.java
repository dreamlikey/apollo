package com.wdq.springframework.beans.factory;

/**
 *
 * The root interface for accessing a Spring bean container.
 * spring bean 容器
 * @author wudq
 * @date 2019/2/22
 */
public interface BeanFactory {
    /**
     * getBean
     * @param beanName
     * @return
     */
    Object getBean(String beanName);
}
