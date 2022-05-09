package com.eastarpen.springframework.beans.factory.support;

import com.eastarpen.springframework.beans.BeansException;
import com.eastarpen.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 通过 java 反射机制实现带 constructor 的bean实例化
 * 不需要导入依赖
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName,
                              Constructor constructor, Object[] args) {
        // 获取 bean  class 信息
        Class beanClass = beanDefinition.getBeanClass();
        try {
            if(null != constructor) {
                // constructor 不为 null, 说明需要调用有参构造实例化对象
                return beanClass.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            } else {
                // constructor 为 null, 直接调用无参构造实例化对象
                return beanClass.getDeclaredConstructor().newInstance();
            }
        } catch (NoSuchMethodException | InstantiationException |
                IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate ["+ beanClass.getName() +"]", e);
        }
    }
}
