package com.example.countryproject.request;


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
    private String CountryName;
    @NotBlank
    private String Description;
    @NotBlank
    private Date DateFounded;
    @NotBlank
    private String FlagToday;

    @Valid
    private ModernFlagRequest modernFlag;

}
