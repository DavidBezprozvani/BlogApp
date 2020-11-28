package com.codeacademy.blogs.repository;

import com.codeacademy.blogs.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
