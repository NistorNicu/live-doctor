package com.doctor.controller;

import com.doctor.entity.Doctor;
import com.doctor.entity.view.DoctorSignupView;
import com.doctor.repository.CountryRepository;
import com.doctor.service.impl.DoctorService;
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
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    DoctorService doctorService;

    @RequestMapping( method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Doctor signupDoctor(@RequestBody DoctorSignupView doctorView){
       return doctorService.addDoctor(doctorView);
    }
}
