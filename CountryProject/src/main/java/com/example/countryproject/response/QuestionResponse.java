package com.example.countryproject.response;

import com.example.countryproject.entity.Country;
import com.example.countryproject.entity.Question;

import javax.persistence.Column;

public class QuestionResponse {
    public long Id;
    public String Question;
    public String Answer;

    public String FakeAnswerOne;
    public String FakeAnswerTwo;
    public String FakeAnswerThree;

    public QuestionResponse(Question question){
        Id = question.getId();
        Question = question.getQuestion();
        Answer = question.getAnswer();
        FakeAnswerOne = question.getFakeAnswerOne();
        FakeAnswerTwo = question.getFakeAnswerTwo();
        FakeAnswerThree = question.getFakeAnswerThree();
    }
}
