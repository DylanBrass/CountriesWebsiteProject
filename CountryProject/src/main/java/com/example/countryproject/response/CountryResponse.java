package com.example.countryproject.response;

import com.example.countryproject.entity.Country;
import com.example.countryproject.entity.ModernFlag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryResponse {
    private long id;

    private String CountryName;

    private String Description;

    private Date DateFounded;

    private ModernFlagResponse FlagToday;

    private String FamousFlagPast;

    public CountryResponse(Country country){
        id = country.getId();
        CountryName = country.getCountryName();
        Description = country.getDescription();
        DateFounded = country.getDateFounded();
        FamousFlagPast = country.getFamousFlagPast();
        if(country.getModernFlag()!=null)
        FlagToday = new ModernFlagResponse((country.getModernFlag()));
    }
}
