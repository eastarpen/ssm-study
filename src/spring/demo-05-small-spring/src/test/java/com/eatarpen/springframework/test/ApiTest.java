package com.eatarpen.springframework.test;

import com.eastarpen.springframework.BeanDefinition;
import com.eastarpen.springframework.BeanFactory;
import com.eatarpen.springframework.test.bean.UserService;
import org.junit.Test;

public class ApiTest {

    @Test
    public void testBeanFactory() {
        // 实例化工厂
        BeanFactory beanFactory = new BeanFactory();

        // 注册 bean
        beanFactory.registerBeanDefinition("userService", new BeanDefinition(new UserService()));

        // 获取 bean
        UserService userService = (UserService)beanFactory.getBean("userService");

        // 调用 bean 方法
        userService.run();
    }
}
