package com.example.countryproject.controller;

import com.example.countryproject.entity.Country;
import com.example.countryproject.entity.Question;
import com.example.countryproject.request.QuestionRequest;
import com.example.countryproject.response.CountryResponse;
import com.example.countryproject.response.QuestionResponse;
import com.example.countryproject.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/countries")
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

    @GetMapping("/{countryId}/questions")
    public List<QuestionResponse> getAllQuestions(@PathVariable long countryId){
        List<Question> questions = countryService.getAllQuestions(countryId);
        List<QuestionResponse> courseResponses = new ArrayList<>();
        for(int i=0; i < questions.size(); i++){
            courseResponses.add(new QuestionResponse(questions.get(i)));
        }

        return courseResponses;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{country_id}/questions")
    public QuestionResponse addQuestion(
            @PathVariable long country_id,
            @Valid @RequestBody QuestionRequest questionRequest
    ){
        return new QuestionResponse(countryService.addQuestion(country_id, questionRequest));
    }
}
