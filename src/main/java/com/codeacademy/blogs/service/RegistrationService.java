package com.codeacademy.blogs.service;

import com.codeacademy.blogs.model.User;
import com.codeacademy.blogs.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;

@Service
public class RegistrationService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RegistrationService registrationService;




    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }


//    public User signup(@Valid User user,
//                       BindingResult bindingResult,
//                       Model model) {
//        if (registrationService.findByEmail(user.getEmail()).isPresent()) {
//            bindingResult
//                    .rejectValue("email", "error.user",
//                            "There is already a user registered with the email provided");
//        }
//        if (registrationService.findByUsername(user.getUsername()).isPresent()) {
//            bindingResult
//                    .rejectValue("username", "error.user",
//                            "There is already a user registered with the username provided");
//        }

//        if (!bindingResult.hasErrors()) {
//            // Registration successful, save user
//            // Set user role to USER and set it as active
//            userRepository.save(user);
}
