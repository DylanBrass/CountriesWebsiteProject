package com.example.countryproject.entity;

import antlr.collections.List;
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
    private String Description;

    @Column(name="flag_url", nullable = false)
    private String FlagPhoto;

    @Column(name="date_first_used", nullable = false)
    private Date DateUsed;



}
