package com.eastarpen.springframework.beans.factory.config;

public interface SingletonBeanRegistry {

    public Object getSingleton(String beanName);
}
