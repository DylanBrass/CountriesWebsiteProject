package com.example.countryproject.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Getter
@Setter
public class ModernFlagRequest {
    @NotBlank
    private String creator;

    @NotBlank
    private String Description;

    @NotBlank
    private String FlagPhoto;

    @NotBlank
    private Date DateUsed;
}
