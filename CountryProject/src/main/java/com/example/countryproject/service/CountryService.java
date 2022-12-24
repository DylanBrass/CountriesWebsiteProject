package com.example.countryproject.service;

import com.example.countryproject.entity.Country;
import com.example.countryproject.entity.Question;
import com.example.countryproject.exception.ResourceNotFoundException;
import com.example.countryproject.repository.CountryRepository;
import com.example.countryproject.repository.QuestionRepository;
import com.example.countryproject.request.QuestionRequest;
import com.example.countryproject.response.CountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    @Autowired
    QuestionRepository questionRepository;
    public List<Country> getAllCountries(String countryNameParam){
        if(countryNameParam == null || countryNameParam.isBlank())
            return (List<Country>) countryRepository.findAll();

        return countryRepository.findAllByCountryNameContainingIgnoreCase(countryNameParam);
    }
    public Question addQuestion(long country_id, QuestionRequest questionRequest){
        Country country =  countryRepository.findById(country_id).orElseThrow(
                ()->new ResourceNotFoundException("country id is not found"));

        Question questionToBeSaved = new Question(questionRequest);
        questionToBeSaved.setCountry(country);

        return questionRepository.save(questionToBeSaved);
    }
    public List<Question> getAllQuestions(long countryId){
        return questionRepository.findAllByCountryId(countryId);
    }


    public Question updateQuestion(long id, QuestionRequest questionRequest){
        if(questionRepository.existsById(id))
        {
            Question questionToBeUpdated = new Question(questionRequest);
            questionToBeUpdated.setId(id);
            return questionRepository.save(questionToBeUpdated);
        }
        else{
            throw new ResourceNotFoundException("Question id not found");
        }
    }
}
