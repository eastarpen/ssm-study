package com.eastarpen.demo04.controller;

import com.eastarpen.demo04.entity.User;
import com.eastarpen.demo04.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloSpringmvcController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/query/{id}")
    public String queryUserById(@PathVariable("id") int id) {
        User user = userService.queryUserById(id);
        return user==null? "{}": user.toString();
    }
}
