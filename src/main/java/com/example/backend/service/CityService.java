package com.example.backend.service;

import com.example.backend.model.City;
import org.springframework.stereotype.Service;

import java.util.List;
public interface CityService {
    City save(City City);

    List<City> getAll();

    City get(long id);

    City update(City City, long id);

    void delete(long id);
}
