package com.eastarpen.springframework.beans.factory;

import com.eastarpen.springframework.beans.BeansException;

public interface BeanFactory {

    /**
     * 获取简单 bean 实例化对象
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;

    /**
     * 获取带有构造方法的 bean 实例化对象
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    Object getBean(String name, Object... args) throws BeansException;
}
