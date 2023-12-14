package com.booklibrary.Book.Library.Project.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.booklibrary.Book.Library.Project.Services.BookService;


    
@Controller
public class MainController {
    
    @Autowired
    BookService bookService;

    @GetMapping("/")
    public String dashboard(){
        return "dashboard";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/search")
    public String getBooksByTitle(@RequestParam(name="title") String title, Model model) throws IOException {
        model.addAttribute("books", bookService.getBooksByTitle(title));
        return "bookdetails";
    }

}
