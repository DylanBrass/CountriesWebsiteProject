package com.example.countryproject.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class QuestionRequest {
    @NotBlank
    public String Question;
    @NotBlank
    public String Answer;
    @NotBlank
    public String FakeAnswerOne;
    @NotBlank
    public String FakeAnswerTwo;
    @NotBlank
    public String FakeAnswerThree;
}
