package com.doctor.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationHandlerController {


    @MessageMapping("consultations")
    public String proccesMessage(String mess){
        return mess.toUpperCase();
    }
}
