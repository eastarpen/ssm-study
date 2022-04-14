package com.eastarpen.demo04.controller;

import com.eastarpen.demo04.entity.User;
import com.eastarpen.demo04.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody  // ResponseBody 指明这个Controller中所有的String 返回均为数据, 不经过视图解析器
public class HelloSpringmvcController {

    private UserService userService;

    /**
     * 自动装配 spring-service.xml 中的 userService
     * @param userService
     */
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * restful 风格的参数传递
     * 请求路径为 /query 后面需要跟上参数 id
     * 若没有{id} 通过 /query?id= 传递参数
     * @param id
     * @return
     */
    @GetMapping("/query/{id}")
    public String queryUserById(@PathVariable("id") int id) {
        User user = userService.queryUserById(id);
        return user==null? "{}": user.toString();
    }
}
