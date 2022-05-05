package com.eastarpen.demo06.service;

import com.eastarpen.demo06.entity.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImplTest {

    private UserService userService = new ClassPathXmlApplicationContext("applicationContext.xml").
            getBean("userServiceImpl", UserService.class);

    @Test
    public void login() {
        User user = new User("admin", "admin");
        System.out.println(userService.login(user));

        user.setPassword("asdf");
        System.out.println(userService.login(user));
    }
}