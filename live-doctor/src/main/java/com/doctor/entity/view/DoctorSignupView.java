package com.doctor.entity.view;

import java.util.Objects;

/**
 * Created by Nicu on 6/17/2016.
 */
public class DoctorSignupView {
    private String name;
    private Long countryId;
    private Long languageId;
    private Long specializationId;

    public Long getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(Long specializationId) {
        this.specializationId = specializationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorSignupView that = (DoctorSignupView) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getCountryId(), that.getCountryId()) &&
                Objects.equals(getLanguageId(), that.getLanguageId()) &&
                Objects.equals(getSpecializationId(), that.getSpecializationId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCountryId(), getLanguageId(), getSpecializationId());
    }
}
