package com.example.countryproject.service;

import com.example.countryproject.entity.Country;
import com.example.countryproject.entity.Question;
import com.example.countryproject.exception.ResourceNotFoundException;
import com.example.countryproject.repository.QuestionRepository;
import com.example.countryproject.request.QuestionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {

        return (List<Question>) questionRepository.findAll();

    }

    public Question updateQuestion(long id, QuestionRequest questionRequest){
        if(questionRepository.existsById(id))
        {
            Question oldQuestion = questionRepository.findById(id).orElseThrow();
            Question questionToBeUpdated = new Question(questionRequest);
            questionToBeUpdated.setId(id);
            questionToBeUpdated.setCountry(oldQuestion.getCountry());
            return questionRepository.save(questionToBeUpdated);
        }
        else{
            throw new ResourceNotFoundException("Question id not found");
        }
    }

    public void deleteQuestion(long id){
        if(questionRepository.existsById(id)){
            questionRepository.deleteById(id);
        }
        else{
            throw new ResourceNotFoundException("Question id not found");
        }
    }
}
