package com.codeacademy.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController{

    //TODO: padaryti index controller

    @RequestMapping({"", "/", "index"})
    public String index() {
        return "blogs/index";
    }
}
