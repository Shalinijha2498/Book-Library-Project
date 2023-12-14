package com.booklibrary.Book.Library.Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan
public class BookLibraryProjectApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(BookLibraryProjectApplication.class, args);
	}
}
