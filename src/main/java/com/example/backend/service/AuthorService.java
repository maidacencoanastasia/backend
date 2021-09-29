package com.example.backend.service;
import com.example.backend.model.Author;
import java.util.List;

public interface AuthorService {
    Author saveAuthor(Author author);
    List<Author> getAllAuthors();
}
