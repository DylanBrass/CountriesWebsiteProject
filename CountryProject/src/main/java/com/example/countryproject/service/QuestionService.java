package com.example.countryproject.service;

import com.example.countryproject.entity.Country;
import com.example.countryproject.entity.Question;
import com.example.countryproject.exception.ResourceNotFoundException;
import com.example.countryproject.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public Question getQuestion(long Id)
    {
        Question question = questionRepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("Question id not found"));
        return question;
    }
    public List<Question> getAllQuestions() {

        return (List<Question>) questionRepository.findAll();

    }
    public List<Question> getAllQuestionsByCountryID(long countryId) {

        return (List<Question>) questionRepository.findAll();
    }
}
