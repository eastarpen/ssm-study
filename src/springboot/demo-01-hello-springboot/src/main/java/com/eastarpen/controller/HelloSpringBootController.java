package com.eastarpen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringBootController {

    @RequestMapping("/hello")
    public String sayHello(@RequestParam(required = false, name = "who") String who) {
        if(who == null || who.equals("")) {
            who = "World";
        }
        return String.format("Hello, %s!", who);
    }

}
