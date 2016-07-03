package com.doctor.controller;

import com.doctor.entity.Consultation;
import com.doctor.entity.view.ConsultationPacientView;
import com.doctor.entity.view.CreateConsultationView;
import com.doctor.service.api.ConsultationServiceApi;
import com.doctor.service.api.ConsultationSessionHandllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Nicu on 6/17/2016.
 */
@CrossOrigin
@RequestMapping("/consultation")
@RestController
public class ConsultationController {


    @Autowired
    private ConsultationServiceApi consultationServiceApi;


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ConsultationPacientView createConsultation(@RequestBody CreateConsultationView createConsultationView){
        return consultationServiceApi.createConsultation(createConsultationView);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    Consultation getConsultation(@RequestParam(name = "id") Long id)  {
        return consultationServiceApi.getConsultation(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Deprecated
    List<Consultation> getConsultations()  {
        return consultationServiceApi.getAllConsultations();
    }

}
