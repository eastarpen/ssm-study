package com.eastarpen.springframework.beans.factory.support;

import com.eastarpen.springframework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {

    /**
     * 注册 bean
     * 将封装了 bean Class 信息的 BeanDefinition 对象存入注册表
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
