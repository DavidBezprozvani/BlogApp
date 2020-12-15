package com.codeacademy.blogs.service;

import com.codeacademy.blogs.exception.UserNotFoundException;
import com.codeacademy.blogs.model.Post;
import com.codeacademy.blogs.model.User;
import com.codeacademy.blogs.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    private PostRepository postRepository;

    // add post
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    // edit post

    // get all posts
    public Page<Post> getAllPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }
    // find post by name keyword

    // find post by user
    public Optional<Post> getPostByUsername(String username) {
        return postRepository.findByUsername(username);
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }


}
