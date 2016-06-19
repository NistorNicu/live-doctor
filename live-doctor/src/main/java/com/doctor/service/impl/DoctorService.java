package com.doctor.service.impl;

import com.doctor.entity.Consultation;
import com.doctor.entity.Doctor;
import com.doctor.entity.converter.DoctorSignupConverter;
import com.doctor.entity.view.DoctorSignupView;
import com.doctor.repository.DoctorRepository;
import com.doctor.service.api.DoctorServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nicu on 6/17/2016.
 */
@Service
public class DoctorService implements DoctorServiceApi {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    DoctorSignupConverter doctorSignupConverter;


    @Override
    public Doctor addDoctor(DoctorSignupView doctorView) {
        Doctor doc =  doctorSignupConverter.convert(doctorView);
       return doctorRepository.saveAndFlush(doc);
    }

    @Override
    public List<Doctor> findEligibleDoctors(Consultation consultation) {
        return doctorRepository.findAllBySpecializationAndLanguage(consultation.getSpecialization(), consultation.getPacient().getLanguage());
    }
}
