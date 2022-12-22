package com.example.countryproject.response;

import com.example.countryproject.entity.ModernFlag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModernFlagResponse {
    private String creator;

    private String Description;

    private String FlagPhoto;

    private Date DateUsed;

    public ModernFlagResponse(ModernFlag modernFlag){
        creator = modernFlag.getCreator();
        Description = modernFlag.getDescription();
        FlagPhoto = modernFlag.getFlagPhoto();
        DateUsed= modernFlag.getDateUsed();
    }

}
