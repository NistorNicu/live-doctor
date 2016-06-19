package com.doctor.entity;

import org.springframework.hateoas.alps.Doc;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Nicu on 6/17/2016.
 */
//TODO Addd status and creation date
@Entity
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "session_id")
    private String sessionId;

    @ManyToOne(targetEntity = Pacient.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "pacient_id")
    private Pacient pacient;

    @ManyToOne(targetEntity = Doctor.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consultation that = (Consultation) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getSessionId(), that.getSessionId()) &&
                Objects.equals(getPacient(), that.getPacient()) &&
                Objects.equals(getDoctor(), that.getDoctor()) &&
                Objects.equals(getSpecialization(), that.getSpecialization());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSessionId(), getPacient(), getDoctor(), getSpecialization());
    }
}
