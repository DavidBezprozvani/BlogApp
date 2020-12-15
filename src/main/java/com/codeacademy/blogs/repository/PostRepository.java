package com.codeacademy.blogs.repository;

import com.codeacademy.blogs.model.Post;
import com.codeacademy.blogs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByUsername(String username);

}
