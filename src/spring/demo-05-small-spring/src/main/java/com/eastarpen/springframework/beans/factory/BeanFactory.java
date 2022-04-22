package com.eastarpen.springframework.beans.factory;

import com.eastarpen.springframework.beans.BeansException;

public interface BeanFactory {

    /**
     * 获取 bean 实例化对象
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;
}
