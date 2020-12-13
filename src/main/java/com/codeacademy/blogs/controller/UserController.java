package com.codeacademy.blogs.controller;

import com.codeacademy.blogs.model.User;
import com.codeacademy.blogs.repository.UserRepository;
import com.codeacademy.blogs.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    //TODO make user controller

    private UserService userService;
    private UserRepository userRepository;

    @GetMapping
    public String getAll(@PageableDefault(size = 5) Pageable pageable, Model model) {
        model.addAttribute("usersPage", userService.getAllUsers(pageable));
        return "**/user-list";
    }

    @GetMapping("/{id}")
    public String getUserProfile(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "**/user-profile";
    }

    @GetMapping("/registration")
    public String getRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "**/registration";
    }

    @PostMapping
    public String addNewUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "**/registration";
        }
        userService.addUser(user);
        return "redirect:/user";
    }

    @GetMapping("/update/{id}")
    public String getUpdateUserForm(Model model, @PathVariable long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "**/edit-user";
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable Long id, BindingResult bindingResult, @ModelAttribute("user") User user) {
        if (bindingResult.hasErrors()) {
            return "**/edit-user";
        }
        userService.updateUser(id, user);
        return "redirect:/user/" + id;
    }


//    @PostMapping
//    public String signUp(@Valid User user,
//                                BindingResult bindingResult,
//                                Model model) {
//
//        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
//            bindingResult
//                    .rejectValue("email", "error.user",
//                            "There is already a user registered with the email provided");
//        }
//        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
//            bindingResult
//                    .rejectValue("username", "error.user",
//                            "There is already a user registered with the username provided");
//        }
//
//        if (!bindingResult.hasErrors()) {
//            // Registration successful, save user
//            // Set user role to USER and set it as active
//            userRepository.save(user);
//
//            model.addAttribute("successMessage", "User has been registered successfully");
//            model.addAttribute("user", new User());
//        }
//
//        return "**/registration";
//    }
}
