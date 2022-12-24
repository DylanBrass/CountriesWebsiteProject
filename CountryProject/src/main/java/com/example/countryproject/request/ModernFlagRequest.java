package com.example.countryproject.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModernFlagRequest {
    @NotNull
    private long id;

    @NotBlank
    private String creator;

    @NotBlank
    private String description;

    @NotBlank
    private String flagPhoto;

    @NotBlank
    private Date dateUsed;
}
