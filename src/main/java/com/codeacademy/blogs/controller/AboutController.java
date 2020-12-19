package com.codeacademy.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AboutController {

    @RequestMapping("public/about")
    public String index() {
        return "about";

    }
}