package com.eastarpen.springframework.beans.factory;

import com.eastarpen.springframework.beans.BeansException;

public interface BeanFactory {

    Object getBean(String name) throws BeansException;
}
