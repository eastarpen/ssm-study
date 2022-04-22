package com.eastarpen.springframework.beans.factory.config;

public interface SingletonBeanRegistry {

    /**
     * 获取 bean 实例
     * @param beanName
     * @return
     */
    public Object getSingleton(String beanName);
}
