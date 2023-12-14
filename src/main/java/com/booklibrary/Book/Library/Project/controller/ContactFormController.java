package com.booklibrary.Book.Library.Project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.booklibrary.Book.Library.Project.model.ContactForm;
import com.booklibrary.Book.Library.Project.repository.ContactFormRepository;

@Controller
public class ContactFormController {

    @Autowired
    private ContactFormRepository contactFormRepository;

    @GetMapping("/contact")
    public String contactForm(Model model) {
        model.addAttribute("formData", new ContactForm());
        return "contact";
    }

    @PostMapping("/submit-form")
    public String submitForm(@ModelAttribute ContactForm formData) {
        contactFormRepository.save(formData);
        return "redirect:/submit-success";
    }

    @GetMapping("/submit-success")
    public String submitSuccess() {
        return "submit-success";
    }

}
