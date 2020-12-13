package com.codeacademy.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController{

    //TODO: padaryti index controller

    @RequestMapping("/")
    public String index() {
        return "blogs/index";
    }
}
