package com.example.countryproject.repository;

import com.example.countryproject.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
    List<Country> findAllByCountryNameContainingIgnoreCase(String countryName);

}
