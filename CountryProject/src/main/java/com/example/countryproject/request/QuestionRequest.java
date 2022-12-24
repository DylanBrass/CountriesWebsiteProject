package com.example.countryproject.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class QuestionRequest {
    @NotBlank
    private String question;
    @NotBlank
    private String answer;
    @NotBlank
    private String fakeAnswerOne;
    @NotBlank
    private String fakeAnswerTwo;
    @NotBlank
    private String fakeAnswerThree;

}
