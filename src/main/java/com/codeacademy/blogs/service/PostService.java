package com.codeacademy.blogs.service;

import com.codeacademy.blogs.exception.PostNotFoundException;
import com.codeacademy.blogs.exception.UserNotFoundException;
import com.codeacademy.blogs.model.Post;
import com.codeacademy.blogs.model.User;
import com.codeacademy.blogs.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // add post
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    // edit post
    public void editPost(Long id, Post newPost) {
        Post existingPost = getPostById(id);
        // FIXME: Use mapper or BeanUtil.
        existingPost.setTitle(newPost.getTitle());
        existingPost.setBody(newPost.getBody());
        existingPost.setUpdatedOn(LocalDateTime.now());
        postRepository.save(existingPost);
    }

    // get all posts
    public Page<Post> getAllPageablePosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public List<Post> getAllPosts() {
      return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(PostNotFoundException::new);
    }

    // TODO: make search to find post by keyword and find post by user

}
