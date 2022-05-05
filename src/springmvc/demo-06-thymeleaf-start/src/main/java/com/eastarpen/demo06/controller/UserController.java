package com.eastarpen.demo06.controller;

import com.eastarpen.demo06.entity.User;
import com.eastarpen.demo06.service.UserService;
import com.eastarpen.demo06.utils.Constant;
import com.eastarpen.demo06.utils.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("login")
    public String loginView(Model model) {
        return "public/login";
    }

    @PostMapping("login")
    @ResponseBody
    public String login(User loginUser, HttpSession session) {
        LoginResult loginResult = userService.login(loginUser);
        if(Constant.LOGIN_SUCCESS == loginResult.getResultCode()) {
            session.setAttribute("user", loginResult.getUser());
        }
        return loginResult.toString();
    }
}
