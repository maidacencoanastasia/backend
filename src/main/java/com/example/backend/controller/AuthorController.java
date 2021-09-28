package com.example.backend.controller;

import com.example.backend.model.Author;
import com.example.backend.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
    return new ResponseEntity<>(authorService.saveAuthor(author), HttpStatus.CREATED);
    }
}
