package com.example.countryproject.entity;
import com.example.countryproject.request.CountryRequest;
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
    private String description;

    @Column(name="date_founded", nullable = false)
    private Date dateFounded;

    @Column(name="flag_past_url")
    private String famousFlagPast;
    @Column(name="map_url")
    private String map;

    @Column(name = "history_text", columnDefinition = "text")
    private String history;

    @OneToOne(cascade = CascadeType.ALL)
    private ModernFlag modernFlag;

    public Country(CountryRequest countryRequest){
        id=countryRequest.getId();
        countryName=countryRequest.getCountryName();
        description=countryRequest.getDescription();
        dateFounded=countryRequest.getDateFounded();
        famousFlagPast=countryRequest.getFamousFlagPast();
        map=countryRequest.getMap();
    }
}
