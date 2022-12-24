package com.example.countryproject.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.security.PublicKey;

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

    @NotNull
    private CountryRequest country;
}
