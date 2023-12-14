package com.booklibrary.Book.Library.Project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.booklibrary.Book.Library.Project.model.SignUpForm;
import com.booklibrary.Book.Library.Project.repository.SignUpRepository;

@Controller
public class SignUpController {
    @Autowired
    private SignUpRepository signUpRepository;

    @GetMapping("/signup")
    public String getSignupForm(Model model){
        model.addAttribute("signUpFormData", new SignUpForm());
        return "signupform";
    }

    @PostMapping("/signup-submit")
    public String getSignUpDetails(@ModelAttribute SignUpForm signUpFormData){
        signUpRepository.save(signUpFormData);
        return "login";
    }
}
