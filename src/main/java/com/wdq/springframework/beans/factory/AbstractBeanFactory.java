package com.wdq.springframework.beans.factory;

/**
 * @author wudq
 * @date 2019/2/22
 */
public abstract class AbstractBeanFactory implements BeanFactory {
    @Override
    public Object getBean(String beanName) {
        return null;
    }

    /**
     * 加载bean
     * @return
     */
    public Object doGetBean() {

        Object bean = createBean();
        Object object = getObjectForBeanInstance(bean);

        return object;
    }

    /**
     * 创建bean实例(实例化bean)
     * @return
     */
    public abstract Object createBean();

    public Object getObjectForBeanInstance(Object bean) {
        return null;
    }
}
