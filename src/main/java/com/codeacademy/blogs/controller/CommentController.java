package com.codeacademy.blogs.controller;

import com.codeacademy.blogs.model.Comment;
import com.codeacademy.blogs.model.Post;
import com.codeacademy.blogs.model.User;
import com.codeacademy.blogs.service.CommentService;
import com.codeacademy.blogs.service.PostService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@RequestMapping("/public/post/comment")
@Controller
public class CommentController {

    private CommentService commentService;
    private PostService postService;

    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

    @GetMapping
    public String getAllPageableComments(@PageableDefault(size = 10) Pageable pageable, Post post, Model model) {
        model.addAttribute("commentsPage", commentService.getAllPageableComments(pageable));
//        model.addAttribute("currentPost", postService.getPostById(post.getId()));
        return "comment/post-comments";
    }

    @GetMapping("/{id}")
    public String getSingleComment(@PathVariable Long id, Model model) {
        model.addAttribute("comment", commentService.getCommentById(id));
        return "comment/single-comment";
    }
}
