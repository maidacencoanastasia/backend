package com.example.backend.service.impl;

import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.model.Country;
import com.example.backend.repository.CountryRepository;
import com.example.backend.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        super();
        this.countryRepository = countryRepository;
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country get(long id) {
        return countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country", "id", id));
    }

    @Override
    public Country update(Country country, long id) {
        Country existingCountry = countryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Country", "ID", id)
        );
        existingCountry.setName(existingCountry.getName());
        countryRepository.save(existingCountry);
        return existingCountry;
    }

    @Override
    public void delete(long id) {
        countryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Country", "ID", id)
        );
        countryRepository.deleteById(id);
    }
}
