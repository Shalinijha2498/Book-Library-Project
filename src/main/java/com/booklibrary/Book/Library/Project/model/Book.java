package com.booklibrary.Book.Library.Project.model;

public class Book {
    private String title;
    private String author;
    private String image;
    private String bookUrl;
    

    public Book(String title, String author, String image, String bookUrl) {
        this.title = title;
        this.author = author;
        this.image = image;
        this.bookUrl = bookUrl;
    }
    //getters and setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public String getBookUrl() {
        return bookUrl;
    }
    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

}
