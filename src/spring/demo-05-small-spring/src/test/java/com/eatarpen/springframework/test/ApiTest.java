package com.eatarpen.springframework.test;

import com.eastarpen.springframework.beans.factory.config.BeanDefinition;
import com.eastarpen.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.eatarpen.springframework.test.bean.UserService;
import org.junit.Test;

public class ApiTest {

    @Test
    public void testBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);

        String name = "userService";
        beanFactory.registerBeanDefinition(name, beanDefinition);

        UserService userService = (UserService) beanFactory.getBean(name);

        beanFactory.getBean("noSuchBean");
    }
}
