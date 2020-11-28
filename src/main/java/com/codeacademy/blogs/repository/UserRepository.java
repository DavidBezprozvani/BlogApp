package com.codeacademy.blogs.repository;

import com.codeacademy.blogs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
