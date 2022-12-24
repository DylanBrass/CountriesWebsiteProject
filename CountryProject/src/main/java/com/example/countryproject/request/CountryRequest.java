package com.example.countryproject.request;


import com.example.countryproject.response.ModernFlagResponse;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Getter
@Setter
public class CountryRequest
{
@NotBlank
    private long id;
@NotBlank
    private String countryName;
@NotBlank
    private String description;
@NotBlank
    private Date dateFounded;

    private String famousFlagPast;

    private  String historyText;

    private String map;


}
