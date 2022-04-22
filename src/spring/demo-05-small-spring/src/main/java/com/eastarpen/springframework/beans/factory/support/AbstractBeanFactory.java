package com.eastarpen.springframework.beans.factory.support;

import com.eastarpen.springframework.beans.BeansException;
import com.eastarpen.springframework.beans.factory.BeanFactory;
import com.eastarpen.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        // 调用 getSingleton 方法获取 bean 的示例
        // getSingleton 在 SingletonBeanRegistry 中定义, 在 DefaultSingletonBenRegistry 中被实现
        Object bean = getSingleton(name);
        if(bean != null) {
            return bean;
        }
        // bean 为 null 说明该 bean 之前未被示例化, 容器中没有 bean 对象 因此需要实例化 bean 且将其存入容器后返回
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
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
    protected abstract Object createBean(String name, BeanDefinition beanDefinition) throws BeansException;
}
