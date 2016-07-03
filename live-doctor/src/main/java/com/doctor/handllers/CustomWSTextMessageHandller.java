package com.doctor.handllers;

import com.doctor.entity.Constants;
import com.doctor.entity.Doctor;
import com.doctor.entity.Pacient;
import com.doctor.entity.view.MessageView;
import com.doctor.entity.view.RequestConsultationView;
import com.doctor.repository.DoctorRepository;
import com.doctor.repository.PacientRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Nicu on 7/2/2016.
 */
@Component
public class CustomWSTextMessageHandller extends TextWebSocketHandler {

    private Map<Doctor, WebSocketSession> doctors = new ConcurrentHashMap<>();
    private Map<Pacient, WebSocketSession> pacients = new ConcurrentHashMap<>();

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PacientRepository pacientRepository;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("Connected :" + session.toString());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        ObjectMapper om = new ObjectMapper();
        MessageView ms = om.readValue(message.getPayload(), MessageView.class);
        switch (ms.getAction()){
            case Constants.LOGIN :
                handlleLogin(ms, session);
                break;
            case Constants.REQUEST_CONSULTATION :
                notifyDoctor(ms);
                break;
            default:
                break;
        }
//
//        sessions.stream().forEach(s -> {
//            try {
//                s.sendMessage(message);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
    }

    private void notifyDoctor(MessageView msMessageView) {
        ObjectMapper om = new ObjectMapper();
        RequestConsultationView requestConsultationView = new RequestConsultationView();
        //setup view
        requestConsultationView.setSessionId(msMessageView.getSessionId());
        requestConsultationView.setConnToken(msMessageView.getDoctorToken());
        requestConsultationView.setSenderId(msMessageView.getSenderId());
        String payload = "empty";
        try {
            payload = om.writeValueAsString(requestConsultationView);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        TextMessage textMessage = new TextMessage(payload);
        doctors.keySet().stream()
                .forEach(d -> {
                    if (d.getId() == msMessageView.getDestinatarId()){
                        try {
                            doctors.get(d).sendMessage(textMessage);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("Disconnected :" + session.toString());
    }

    private void handlleLogin(MessageView mv, WebSocketSession webSocketSession){
        if (mv.getActor().equals(Constants.DOCTOR)){
            doctors.put(doctorRepository.findOne(mv.getSenderId()), webSocketSession);
        } else{
            pacients.put(pacientRepository.getOne(mv.getSenderId()),webSocketSession);
        }
    }
}
