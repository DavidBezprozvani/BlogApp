package com.codeacademy.blogs.repository;

import com.codeacademy.blogs.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
