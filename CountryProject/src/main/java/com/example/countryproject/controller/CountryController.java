package com.example.countryproject.controller;

import com.example.countryproject.entity.Country;
import com.example.countryproject.response.CountryResponse;
import com.example.countryproject.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/Countries")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping()
    public List<CountryResponse> getAllCountries(@RequestParam(required = false) String countryName){

        List<Country> countries = countryService.getAllCountries(countryName);
        List<CountryResponse> countryResponses = new ArrayList<>();
        countries.forEach(country -> {
            CountryResponse countryResponse = new CountryResponse(country);
            countryResponses.add(countryResponse);
        });
        return countryResponses;
    }
}
