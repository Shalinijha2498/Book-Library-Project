package com.booklibrary.Book.Library.Project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.booklibrary.Book.Library.Project.model.SignUpForm;
import com.booklibrary.Book.Library.Project.repository.SignUpRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LogInController {

    @Autowired
    private SignUpRepository signUpRepository;
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        SignUpForm user = signUpRepository.findByEmailAndPassword(email, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "dashboard";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "signupform";
        }
    }

}
