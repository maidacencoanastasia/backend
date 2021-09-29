package com.example.backend.service.impl;

import com.example.backend.model.Author;
import com.example.backend.repository.AuthorRepository;
import com.example.backend.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        super();
        this.authorRepository = authorRepository;
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author) ;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
