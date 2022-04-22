package com.eatarpen.springframework.test;

import com.eastarpen.springframework.beans.factory.config.BeanDefinition;
import com.eastarpen.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.eatarpen.springframework.test.bean.UserService;
import org.junit.Test;

public class ApiTest {

    @Test
    public void testBeanFactory() {
        // 实例化工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 将 UserService.class 封装为 BeanDefinition
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);

        // 注册 userService
        String name = "userService";
        beanFactory.registerBeanDefinition(name, beanDefinition);

        // 获取 UserService 实例对象
        UserService userService = (UserService) beanFactory.getBean(name);

        // 验证单例模式
        UserService singleton = (UserService) beanFactory.getBean(name);

        // 输出为 true, 说明 userService 和 singleton 为 UserService 的同一实例
        System.out.println(userService==singleton);
    }
}
