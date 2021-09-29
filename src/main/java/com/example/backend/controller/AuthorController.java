package com.example.backend.controller;

import com.example.backend.model.Author;
import com.example.backend.model.Country;
import com.example.backend.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("authors")
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        super();
        this.authorService = authorService;
    }

    // Rest API
    @PostMapping("")
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author) {
        return new ResponseEntity<>(authorService.saveAuthor(author), HttpStatus.CREATED);
    }

    // build get all authors REST API
    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    // build get author by id
    @GetMapping("{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") long authorId) {
        return new ResponseEntity<Author>(authorService.getAuthorById(authorId), HttpStatus.OK);
    }

    // build update
    @PutMapping("{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable("id") long authorId, @RequestBody Author author) {
        return new ResponseEntity<Author>(authorService.updateAuthor(author, authorId), HttpStatus.OK);
    }
}
