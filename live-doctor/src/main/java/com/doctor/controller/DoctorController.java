package com.doctor.controller;

import com.doctor.entity.Doctor;
import com.doctor.entity.view.DoctorSignupView;
import com.doctor.repository.CountryRepository;
import com.doctor.service.impl.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Nicu on 6/17/2016.
 */
@CrossOrigin
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

    @RequestMapping( method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<Doctor> getRegistredDoctors(){
        return doctorService.getRegistredDoctors();
    }
}
