package com.doctor.entity.view;

import com.google.common.base.Objects;

/**
 * Created by Nicu on 7/3/2016.
 */
public class MessageView {

    private Long senderId;
    private String action;
    private String actor;
    private Long destinatarId;
    private String sessionId;
    private String doctorToken;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getDoctorToken() {
        return doctorToken;
    }

    public void setDoctorToken(String doctorToken) {
        this.doctorToken = doctorToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageView that = (MessageView) o;
        return Objects.equal(getSenderId(), that.getSenderId()) &&
                Objects.equal(getAction(), that.getAction()) &&
                Objects.equal(getActor(), that.getActor()) &&
                Objects.equal(getDestinatarId(), that.getDestinatarId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getSenderId(), getAction(), getActor(), getDestinatarId());
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Long getDestinatarId() {
        return destinatarId;
    }

    public void setDestinatarId(Long destinatarId) {
        this.destinatarId = destinatarId;
    }
}
