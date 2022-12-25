package com.example.countryproject.controller;

import com.example.countryproject.entity.Country;
import com.example.countryproject.entity.Question;
import com.example.countryproject.request.QuestionRequest;
import com.example.countryproject.response.CountryResponse;
import com.example.countryproject.response.QuestionResponse;
import com.example.countryproject.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;



    @GetMapping()
    public List<QuestionResponse> getAllQuestions() {

        List<Question> questions = questionService.getAllQuestions();
        List<QuestionResponse> questionResponses = new ArrayList<>();
        questions.forEach(question -> {
            QuestionResponse questionResponse = new QuestionResponse(question);
            questionResponses.add(questionResponse);
        });
        return questionResponses;
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable long id)
    {
        questionService.deleteQuestion(id);
    }
}