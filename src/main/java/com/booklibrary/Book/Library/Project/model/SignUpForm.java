package com.booklibrary.Book.Library.Project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Signup_details")
public class SignUpForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String password;
    //constructor

    public SignUpForm() {

    }
    @Override
    public String toString() {
        return "SignUpForm [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
    }
    public SignUpForm(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    // getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
    
}
