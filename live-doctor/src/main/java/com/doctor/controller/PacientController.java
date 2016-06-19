package com.doctor.controller;

import com.doctor.entity.Pacient;
import com.doctor.entity.view.PacientSignupView;
import com.doctor.service.api.PacientServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nicu on 6/17/2016.
 */
@RestController
@RequestMapping("/pacient")
public class PacientController {

    @Autowired
    private PacientServiceApi pacientServiceApi;

    @RequestMapping(path = "/" , method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Pacient addPacient(@RequestBody PacientSignupView pacientView){
        return pacientServiceApi.addPacient(pacientView);
    }
}
