package com.codeacademy.blogs.service;

import com.codeacademy.blogs.exception.UserNotFoundException;
import com.codeacademy.blogs.model.User;
import com.codeacademy.blogs.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    // get all users
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    // get user by id
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    // update user info

    // remove user for admin


}
