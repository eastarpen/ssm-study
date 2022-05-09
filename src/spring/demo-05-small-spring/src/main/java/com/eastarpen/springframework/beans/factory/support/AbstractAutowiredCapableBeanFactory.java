package com.eastarpen.springframework.beans.factory.support;

import com.eastarpen.springframework.beans.BeansException;
import com.eastarpen.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public abstract class AbstractAutowiredCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    /**
     * 调用 createBeanInstance 方法实例化 bean 并将实例化对象放入容器
     * @param name
     * @param beanDefinition
     * @param args
     * @return
     * @throws BeansException
     */
    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            // 实例化 bean
            bean = createBeanInstance(beanDefinition, name, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        // bean 对象放入容器
        addSingleton(name, bean);
        return bean;
    }

    /**
     * 调用 InstantiationStrategy 完成实例化
     * @param beanDefinition
     * @param beanName
     * @param args
     * @return
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class beanClass = beanDefinition.getBeanClass();
        Constructor[] declaredConstructor = beanClass.getDeclaredConstructors();
        // 遍历 Class 的构造方法, 找到符合传入参数的构造方法 找不到则为 null 即无参构造
        for (Constructor ctor : declaredConstructor) {
            if(null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
