package com.booklibrary.Book.Library.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booklibrary.Book.Library.Project.model.SignUpForm;

public interface SignUpRepository extends JpaRepository<SignUpForm,Long> {
    
    SignUpForm findByEmailAndPassword(String email, String password);
    
}
