package com.eastarpen.springframework.beans.factory.support;

import com.eastarpen.springframework.beans.BeansException;
import com.eastarpen.springframework.beans.factory.BeanFactory;
import com.eastarpen.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(final String name, final Object[] args) {
        return doGetBean(name, args);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if(bean != null) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    /**
     *  从注册表中获取指定的 BeanDefinition 以便实例化 bean
     *  BeanDefinition 存储着 bean 的 Class 信息
     * @param beanName
     * @return
     * @throws BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 将 bean 实例化并存入容器
     * @param name
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    protected abstract Object createBean(String name, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
