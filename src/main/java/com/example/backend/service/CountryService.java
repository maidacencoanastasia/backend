package com.example.backend.service;

import com.example.backend.model.Country;

import java.util.List;

public interface CountryService {
    Country save(Country country);
    List<Country> getAll();
    Country get(long id);
}
