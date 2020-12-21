package com.codeacademy.blogs.controller;

import com.codeacademy.blogs.model.Post;
import com.codeacademy.blogs.model.User;
import com.codeacademy.blogs.repository.PostRepository;
import com.codeacademy.blogs.service.CommentService;
import com.codeacademy.blogs.service.PostService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/public/post")
public class PostController {
    private PostService postService;
    private PostRepository postRepository;
    private CommentService commentService;

    public PostController(PostService postService, PostRepository postRepository) {
        this.postRepository = postRepository;
        this.postService = postService;
    }

    //get all posts
    @GetMapping
    public String getAllPageablePosts(@PageableDefault(size = 5) Pageable pageable, Model model) {
        model.addAttribute("postsPage", postService.getAllPageablePosts(pageable));
        return "post/post-list";
    }

    @GetMapping("/{id}")
    public String getSinglePost(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "post/single-post";
    }

    //create new post only ADMIN
    @GetMapping("/post-form")
    @PreAuthorize("hasRole('ADMIN')")
    public String getCreateNewPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "post/post-form";
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String createNewPost(@ModelAttribute("post") @Valid Post post,
                                BindingResult bindingResult,
                                @AuthenticationPrincipal User user) {
        if (bindingResult.hasErrors()) {
            return "post/post-form";
        } else {
            post.setUsername(user.getUsername());
            postService.addPost(post);
            return "redirect:/public/post/";
        }
    }

    //edit post only ADMIN
    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String getEditPostForm(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "post/edit-post";
    }


    @PostMapping("/edit")
    @PreAuthorize("hasRole('ADMIN')")
    public String editPost(@ModelAttribute("post") @Valid Post post,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "post/edit-post";
        } else {
            postService.editPost(post);
            return "redirect:/public/post";
        }
    }

    //Delete post only ADMIN
    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return "redirect:/public/post/";
    }
}
