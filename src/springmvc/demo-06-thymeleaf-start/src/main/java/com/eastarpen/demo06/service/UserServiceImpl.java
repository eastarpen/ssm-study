package com.eastarpen.demo06.service;

import com.eastarpen.demo06.dao.UserDao;
import com.eastarpen.demo06.entity.User;
import com.eastarpen.demo06.utils.Constant;
import com.eastarpen.demo06.utils.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public LoginResult login(User loginUser) {
        User queryUser = userDao.queryUserByName(loginUser.getName());
        int loginResultCode = Constant.PASSWORD_WRONG;
        if(queryUser == null) {
            loginResultCode = Constant.NO_USERNAME;
        } else if(loginUser.equals(queryUser)) {
            loginResultCode = Constant.LOGIN_SUCCESS;
        }
        return new LoginResult(loginResultCode, loginUser.getName());
    }
}
