package com.codeacademy.blogs.repository;

import com.codeacademy.blogs.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
