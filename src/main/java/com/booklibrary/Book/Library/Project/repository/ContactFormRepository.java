package com.booklibrary.Book.Library.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booklibrary.Book.Library.Project.model.ContactForm;

public interface ContactFormRepository extends JpaRepository<ContactForm, Long> {
}
