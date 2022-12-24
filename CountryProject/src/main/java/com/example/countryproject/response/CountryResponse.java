package com.example.countryproject.response;

import com.example.countryproject.entity.Country;
import com.example.countryproject.entity.ModernFlag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
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

    private ModernFlagResponse modernFlag;

    private String FamousFlagPast;

    private  String HistoryText;
    private String Map;
    public CountryResponse(Country country){
        id = country.getId();
        CountryName = country.getCountryName();
        Description = country.getDescription();
        DateFounded = country.getDateFounded();
        FamousFlagPast = country.getFamousFlagPast();
        Map=country.getMap();
        if(country.getHistory()!=null)
        HistoryText = country.getHistory();

        if(country.getModernFlag()!=null)
        modernFlag = new ModernFlagResponse((country.getModernFlag()));

    }
}
