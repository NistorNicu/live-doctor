package com.doctor.entity.view;

import java.util.Objects;

/**
 * Created by Nicu on 6/17/2016.
 */
public class CreateConsultationView {

    private Long pacientId;
    private Long SpecializationId;

    public Long getPacientId() {
        return pacientId;
    }

    public void setPacientId(Long pacientId) {
        this.pacientId = pacientId;
    }

    public Long getSpecializationId() {
        return SpecializationId;
    }

    public void setSpecializationId(Long specializationId) {
        SpecializationId = specializationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateConsultationView that = (CreateConsultationView) o;
        return Objects.equals(getPacientId(), that.getPacientId()) &&
                Objects.equals(getSpecializationId(), that.getSpecializationId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPacientId(), getSpecializationId());
    }
}
