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

    private PostRepository postRepository;

    @RequestMapping("public/index")
    public String index(Model model) {
//        List<Post> posts = postRepository.findAll();
//        model.addAttribute("posts", posts);
        return "index";
    }
}
