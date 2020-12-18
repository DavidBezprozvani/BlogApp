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

@Controller
@RequestMapping("/private/user")
public class UserPrivateController {

    private UserService userService;
    private UserRepository userRepository;

    public UserPrivateController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String getAll(@PageableDefault(size = 5) Pageable pageable, Model model) {
        model.addAttribute("usersPage", userService.getAllUsers(pageable));
        return "user/user-list";
    }

    @GetMapping("/{id}")
    public String getUserProfile(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/user-profile";
    }

    @GetMapping("/update/{id}")
    @PreAuthorize("isAuthenticated()")
    public String getUpdateUserForm(Model model, @PathVariable Long id, @AuthenticationPrincipal User user) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/edit-user";
    }

    @PostMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public String updateUser(@PathVariable Long id, BindingResult bindingResult, @ModelAttribute("user") @AuthenticationPrincipal User user) {
        if (bindingResult.hasErrors()) {
            return "user/edit-user";
        }
        userService.updateUser(id, user);
        return "redirect:/private/user/" + id;
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/private/user";
    }
}
