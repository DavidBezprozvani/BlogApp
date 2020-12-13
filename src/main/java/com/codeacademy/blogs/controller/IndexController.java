package com.codeacademy.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public/index")
public class IndexController{

    //TODO: padaryti index controller

    public String index() {
        return "index";
    }
}
