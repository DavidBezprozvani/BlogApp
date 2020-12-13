package com.codeacademy.blogs.service;

import com.codeacademy.blogs.config.SecurityConfig;
import com.codeacademy.blogs.exception.UserNotFoundException;
import com.codeacademy.blogs.model.User;
import com.codeacademy.blogs.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    private SecurityConfig securityConfig;

    //TODO: padaryti user service

    // get all users
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    // get user by id
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    // Load User by username
    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    // Find by email // GAL NEREIKALINGI??
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
    }

    // Find by username // GAL NEREIKALINGI??
    public User findByUsername(String email) {
        return userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
    }


    // update user info
    public void updateUser(Long id, User newUser) {
        User existingUser = getUserById(id);
        // FIXME: Use mapper or BeanUtil.
        existingUser.setFirstName(newUser.getFirstName());
        existingUser.setLastName(newUser.getLastName());
        existingUser.setAvatar(newUser.getAvatar());
        userRepository.save(existingUser);
    }

    // add user by admin
    public User addUser(User user) {
        user.setPassword(securityConfig.encoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    // remove user for admin





}
