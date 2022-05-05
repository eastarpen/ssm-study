package com.eastarpen.demo06.service;

import com.eastarpen.demo06.utils.LoginResult;
import com.eastarpen.demo06.entity.User;

public interface UserService {

    public LoginResult login(User user);
}
