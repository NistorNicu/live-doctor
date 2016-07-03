package com.doctor.entity.view;

/**
 * Created by Nicu on 7/3/2016.
 */
public class RequestConsultationView {
    private String sessionId;
    private String connToken;
    private Long senderId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getConnToken() {
        return connToken;
    }

    public void setConnToken(String connToken) {
        this.connToken = connToken;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }
}
