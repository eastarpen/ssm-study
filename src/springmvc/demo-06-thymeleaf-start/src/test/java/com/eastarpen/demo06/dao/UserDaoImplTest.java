package com.eastarpen.demo06.dao;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoImplTest {

    UserDao userDao = new ClassPathXmlApplicationContext("applicationContext.xml").getBean("userDaoImpl",
            UserDao.class);

    @Test
    public void queryUserById() {
        System.out.println(userDao.queryUserById(1));
    }

    @Test
    public void queryUserByName() {
        System.out.println(userDao.queryUserByName("admin"));
    }
}