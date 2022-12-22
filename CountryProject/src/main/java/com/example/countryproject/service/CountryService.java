package com.example.countryproject.service;

import com.example.countryproject.entity.Country;
import com.example.countryproject.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;
    public List<Country> getAllCountries(String countryNameParam){
        if(countryNameParam == null || countryNameParam.isBlank())
            return (List<Country>) countryRepository.findAll();

        return countryRepository.findAllByCountryNameContainingIgnoreCase(countryNameParam);
    }
}
