package com.codeacademy.blogs.service;

import com.codeacademy.blogs.exception.PostNotFoundException;
import com.codeacademy.blogs.exception.UserNotFoundException;
import com.codeacademy.blogs.model.Comment;
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

    public Page<Post> getAllPageablePosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(PostNotFoundException::new);
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    public Post editPost(Post postFromModel) {
        Post postToEdit = postRepository.getOne(postFromModel.getId());
        postToEdit.setTitle(postFromModel.getTitle());
        postToEdit.setBody(postFromModel.getBody());
        return postRepository.save(postToEdit);
    }




    // TODO: make search to find post by keyword and find post by user

}
