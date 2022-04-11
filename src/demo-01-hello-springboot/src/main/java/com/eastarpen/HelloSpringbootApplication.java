package com.eastarpen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringbootApplication.class, args);
    }

    @RequestMapping("/hello")
    public String sayHello(@RequestParam(required = false, name = "who") String who) {
        if(who == null || who.equals("")) {
            who = "World";
        }
        return String.format("Hello, %s!", who);
    }

}
