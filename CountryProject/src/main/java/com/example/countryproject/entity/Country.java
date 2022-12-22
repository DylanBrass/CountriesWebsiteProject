package com.example.countryproject.entity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Entity
@Table(name="Countries")
@Getter
@Setter
@NoArgsConstructor
public class Country {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="country_name", nullable = false)
    private String countryName;

    @Column(name="description", nullable = false)
    private String Description;

    @Column(name="date_founded", nullable = false)
    private Date DateFounded;

    @Column(name="flag_past_url")
    private String FamousFlagPast;

    @OneToOne(cascade = CascadeType.ALL)
    private ModernFlag modernFlag;
}
