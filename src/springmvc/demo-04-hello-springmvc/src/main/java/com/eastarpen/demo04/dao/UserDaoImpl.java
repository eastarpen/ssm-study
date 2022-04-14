package com.eastarpen.demo04.dao;

import com.eastarpen.demo04.entity.User;

import java.util.List;

public class UserDaoImpl implements UserDao {

    /**
     * 模拟数据库
     */
    private List<User> userList;

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public User queryUserById(int id) {
        User user = null;
        for (User u : userList) {
            if(u.getId() == id) {
                user = u;
                break;
            }
        }
        return user;
    }
}
