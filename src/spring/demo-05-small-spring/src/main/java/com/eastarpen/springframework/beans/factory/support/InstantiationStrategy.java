package com.eastarpen.springframework.beans.factory.support;

import com.eastarpen.springframework.beans.factory.config.BeanDefinition;

// Constructor provides information about, and access to, a single constructor for a class
import java.lang.reflect.Constructor;

public interface InstantiationStrategy {

    /**
     *
     * @param beanDefinition
     * @param beanName
     * @param constructor
     * @param args
     * @return
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor,
                       Object[] args);
}
