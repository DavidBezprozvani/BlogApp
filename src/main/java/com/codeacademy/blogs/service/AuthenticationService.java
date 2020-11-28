package com.codeacademy.blogs.service;

import com.codeacademy.blogs.model.RegisterRequest;
import com.codeacademy.blogs.model.User;
import com.codeacademy.blogs.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthenticationService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setUserName(registerRequest.getUsername());
        user.setPassword(encodePassword(registerRequest.getPassword()));
        user.setEmail(registerRequest.getEmail());
        userRepository.save(user);
    }
}
