package com.codeacademy.blogs.controller;

import com.codeacademy.blogs.model.Comment;
import com.codeacademy.blogs.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CommentController {
    //TODO make comment controller

    private CommentService commentService;

    @PostMapping("/create-comment")
    public String createNewPost(@Valid Comment comment,
                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/commentForm";

        } else {
            commentService.save(comment);
            return "redirect:/post/" + comment.getPost().getId();
        }
    }
}
