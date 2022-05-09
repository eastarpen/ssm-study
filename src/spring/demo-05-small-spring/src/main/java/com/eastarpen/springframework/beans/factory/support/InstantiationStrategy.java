package com.eastarpen.springframework.beans.factory.support;

import com.eastarpen.springframework.beans.factory.config.BeanDefinition;

// Constructor provides information about, and access to, a single constructor for a class
import java.lang.reflect.Constructor;

/**
 * 实例化接口, 定义实例化方法
 */
public interface InstantiationStrategy {

    /**
     * 定义实例化
     * @param beanDefinition
     * @param beanName
     * @param constructor
     * @param args          可以为 null, 为 null 则为无参构造
     * @return
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor,
                       Object[] args);
}
