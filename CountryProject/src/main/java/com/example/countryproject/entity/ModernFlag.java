package com.example.countryproject.entity;

import antlr.collections.List;
import com.example.countryproject.request.ModernFlagRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="modern_flag")
@Getter
@Setter
@NoArgsConstructor
public class ModernFlag {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="creator", nullable = false)
    private String creator;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="flag_url", nullable = false)
    private String flagPhoto;

    @Column(name="date_first_used", nullable = false)
    private Date dateUsed;



    public ModernFlag(ModernFlagRequest modernFlagRequest){
        id=modernFlagRequest.getId();
        creator=modernFlagRequest.getCreator();
        description= modernFlagRequest.getDescription();
        flagPhoto= modernFlagRequest.getFlagPhoto();
        dateUsed=modernFlagRequest.getDateUsed();
    }
}
