package com.example.backend.service.impl;

import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.model.Author;
import com.example.backend.repository.AuthorRepository;
import com.example.backend.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(long id) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent()) {
            return author.get();
        } else {
            throw new ResourceNotFoundException("Id", "Author", id);
        }
    }

    @Override
    public Author updateAuthor(Author author, long id) {
        Author existingAuthor = authorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Author", "ID", id)
        );
        existingAuthor.setName(author.getName());
        existingAuthor.setSurname(author.getSurname());
        existingAuthor.setDop_info(author.getDop_info());
        authorRepository.save(existingAuthor);
        return existingAuthor;
    }

    @Override
    public void deleteAuthor(long id) {
        authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "ID", id));
        authorRepository.deleteById(id);
    }
}
