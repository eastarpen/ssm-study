package com.eastarpen.demo04.service;

import com.eastarpen.demo04.dao.UserDao;
import com.eastarpen.demo04.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User queryUserById(int id) {
        return userDao.queryUserById(id);
    }
}
