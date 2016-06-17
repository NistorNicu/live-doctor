package com.doctor.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Nicu on 6/17/2016.
 */
@Entity(name = "doctor")
public class Doctor {
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

    @JoinColumn(name = "specialization_id")
    @ManyToOne(targetEntity = Specialization.class, fetch = FetchType.EAGER)
    private Specialization specialization;

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(getId(), doctor.getId()) &&
                Objects.equals(getName(), doctor.getName()) &&
                Objects.equals(getCountry(), doctor.getCountry()) &&
                Objects.equals(getLanguage(), doctor.getLanguage()) &&
                Objects.equals(getSpecialization(), doctor.getSpecialization());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCountry(), getLanguage(), getSpecialization());
    }
}
