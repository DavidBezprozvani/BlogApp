package com.codeacademy.blogs.controller;

import com.codeacademy.blogs.model.Post;
import com.codeacademy.blogs.repository.PostRepository;
import com.codeacademy.blogs.service.PostService;
import com.codeacademy.blogs.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/public/post")
public class PostController {
    private PostService postService;
    private PostRepository postRepository;

    public PostController(PostService postService, PostRepository postRepository) {
        this.postRepository = postRepository;
        this.postService = postService;
    }
    //TODO make post controller


    //get all posts
    @GetMapping
    public String getAll(@PageableDefault(size = 5) Pageable pageable, Model model) {
        model.addAttribute("postsPage", postService.getAllPosts(pageable));
        return "post/post-list";
    }

    @GetMapping("/{id}")
    public String getSingleProduct(@PathVariable long id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "post/single-post";
    }

    //create new post
    @PostMapping("/new-post")
    public String createNewPost(@Valid Post post, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "post/post-form";
        } else {
            postService.addPost(post);
            return "redirect:/blog/" + post.getUser().getUsername();
        }
    }

    //edit post
    @GetMapping("/edit/{id}")
    public String editBlog(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "*/edit-post";
        }

    //Delete post
    @RequestMapping
    public String deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return "*/post-list";
    }

//    private boolean isPrincipalOwnerOfPost(Principal principal, Post post) {
//        return principal != null && principal.getName().equals(post.getUser().getUsername());
//    }
}
