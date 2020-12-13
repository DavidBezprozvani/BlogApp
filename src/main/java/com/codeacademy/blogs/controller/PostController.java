package com.codeacademy.blogs.controller;

import com.codeacademy.blogs.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostController {
    private PostRepository postRepository;
    //TODO make post controller



    @RequestMapping
    public String deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return "/post-list";
    }
}
