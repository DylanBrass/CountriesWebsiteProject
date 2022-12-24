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
    private long id;
    private String creator;

    private String description;

    private String flagPhoto;

    private Date dateUsed;

    public ModernFlagResponse(ModernFlag modernFlag){
        id=modernFlag.getId();
        creator = modernFlag.getCreator();
        description = modernFlag.getDescription();
        flagPhoto = modernFlag.getFlagPhoto();
        dateUsed= modernFlag.getDateUsed();
    }

}
