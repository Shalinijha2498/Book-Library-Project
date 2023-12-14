package com.booklibrary.Book.Library.Project.Services;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.booklibrary.Book.Library.Project.model.Book;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class BookService {
    private final RestTemplate restTemplate = new RestTemplate();

    public List<Book> getBooksByTitle(String title) throws IOException {
        String url = "http://openlibrary.org/search.json?title=" + title;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode json = objectMapper.readTree(response.getBody());
        JsonNode docs = json.get("docs");
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            JsonNode bookJson = docs.get(i);
            String bookTitle = bookJson.get("title").asText();
            String bookAuthor = null;
            if (bookJson.has("author_name")) {
                bookAuthor = bookJson.get("author_name").get(0).asText();
            }
            String imageUrl = null;
            if (bookJson.has("cover_i")) {
                imageUrl = "http://covers.openlibrary.org/b/id/" + bookJson.get("cover_i").asText() + "-M.jpg";
            }
            else{
                imageUrl = "https://img.freepik.com/free-vector/blank-book-white-background_1308-23052.jpg?w=826&t=st=1674023641~exp=1674024241~hmac=a6c0e7b0f307295e365dc0031e0324c58da382dd4a1dd1807102ead308395800";
            }
            String bookUrl = null;
            if (bookJson.has("key")) {
                bookUrl = "https://openlibrary.org" + bookJson.get("key").asText();
            }
            books.add(new Book(bookTitle, bookAuthor, imageUrl, bookUrl));
        }
        return books;
    }
    
}


