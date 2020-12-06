package com.codeacademy.blogs.controller;

import com.codeacademy.blogs.model.User;
import com.codeacademy.blogs.repository.UserRepository;
import com.codeacademy.blogs.service.RegistrationService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.WebRequest;

@Controller
public class RegistrationController {
    private RegistrationService registrationService;
    private UserRepository userRepository;


    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @GetMapping("/user/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }
}


