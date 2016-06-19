package com.doctor.entity;

import javax.persistence.*;

/**
 * Created by Nicu on 6/16/2016.
 */
@Entity(name = "pacient")
public class Pacient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "country_id")
    @ManyToOne(targetEntity = Country.class, fetch = FetchType.EAGER)
    private Country country;
    @JoinColumn(name = "language_id")
    @ManyToOne(targetEntity = Language.class, fetch = FetchType.EAGER)
    private Language language;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }


}
