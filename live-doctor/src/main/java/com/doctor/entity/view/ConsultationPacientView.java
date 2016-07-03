package com.doctor.entity.view;

import com.doctor.entity.Doctor;
import com.google.common.base.Objects;

import java.util.List;

/**
 * Created by Nicu on 7/3/2016.
 */
public class ConsultationPacientView {
    private String docotrToken;
    private String pacientToken;
    private String sessionId;
    private List<Doctor> availableDoctors;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsultationPacientView that = (ConsultationPacientView) o;
        return Objects.equal(getDocotrToken(), that.getDocotrToken()) &&
                Objects.equal(getPacientToken(), that.getPacientToken()) &&
                Objects.equal(getSessionId(), that.getSessionId()) &&
                Objects.equal(getAvailableDoctors(), that.getAvailableDoctors());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getDocotrToken(), getPacientToken(), getSessionId(), getAvailableDoctors());
    }

    public String getDocotrToken() {
        return docotrToken;
    }

    public void setDocotrToken(String docotrToken) {
        this.docotrToken = docotrToken;
    }

    public String getPacientToken() {
        return pacientToken;
    }

    public void setPacientToken(String pacientToken) {
        this.pacientToken = pacientToken;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public List<Doctor> getAvailableDoctors() {
        return availableDoctors;
    }

    public void setAvailableDoctors(List<Doctor> availableDoctors) {
        this.availableDoctors = availableDoctors;
    }
}
