package com.wdq.springframework.beans.factory;

/**
 * @author wudq
 * @date 2019/2/22
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    public Object createBean() {
        Object beanInstance = doCreateBean();
        return beanInstance;
    }


    /**
     * 执行实例化动作
     * @return
     */
    public Object doCreateBean() {
        populateBean();
        Object object = initializeBean();
        return null;
    }

    /**
     * 属性注入
     */
    public void populateBean() {

    }

    /**
     * 实例化bean
     * @return
     */
    public Object initializeBean() {

        populateBean();


        return null;
    }

}
