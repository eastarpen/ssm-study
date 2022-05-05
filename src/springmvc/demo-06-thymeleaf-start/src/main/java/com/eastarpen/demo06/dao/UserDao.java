package com.eastarpen.demo06.dao;

import com.eastarpen.demo06.entity.User;

public interface UserDao {

    User queryUserById(int id);

    User queryUserByName(String name);
}
