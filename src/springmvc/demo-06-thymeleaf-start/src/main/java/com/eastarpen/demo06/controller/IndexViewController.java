package com.eastarpen.demo06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexViewController {

    @GetMapping({"/", "index", "index.html"})
    public String indexView() {
        return "public/login";
    }
}
