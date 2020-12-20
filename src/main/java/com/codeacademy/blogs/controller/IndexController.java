package com.codeacademy.blogs.controller;

import com.codeacademy.blogs.model.Post;
import com.codeacademy.blogs.repository.PostRepository;
import com.codeacademy.blogs.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class IndexController{


    @RequestMapping("public/index")
    public String index() {
        return "index";
    }
}
