package com.project.EventManagement.Controller;

import com.project.EventManagement.Model.User;
import com.project.EventManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // Display registration form
    @GetMapping("/register")
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // Handle registration form submission
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/login";
    }

    // Display login form
    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    // Handle login form submission
    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user, Model model) {
        if (userService.isValidUser(user.getUsername(), user.getPassword())) {
            return "redirect:http://127.0.0.1:5500/index.html";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
