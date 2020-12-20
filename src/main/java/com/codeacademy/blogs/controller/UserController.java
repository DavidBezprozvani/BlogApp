package com.codeacademy.blogs.controller;

import com.codeacademy.blogs.model.User;
import com.codeacademy.blogs.repository.UserRepository;
import com.codeacademy.blogs.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/public/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String getRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "user/registration";
    }

    @PostMapping()
    public String registerNewUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "user/registration";
        }
        userService.addUser(user);
        return "redirect:/public/index";
    }
}
