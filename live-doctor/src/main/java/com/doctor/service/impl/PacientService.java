package com.doctor.service.impl;

import com.doctor.entity.Pacient;
import com.doctor.entity.converter.PacientSignupConverter;
import com.doctor.entity.view.PacientSignupView;
import com.doctor.repository.PacientRepository;
import com.doctor.service.api.PacientServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nicu on 6/17/2016.
 */
@Service
public class PacientService implements PacientServiceApi {

    @Autowired
    PacientRepository pacientRepository;

    @Autowired
    PacientSignupConverter pacientSignupConverter;

    @Override
    public Pacient addPacient(PacientSignupView pacientView) {
        return pacientRepository.saveAndFlush(pacientSignupConverter.convert(pacientView));
    }

    @Override
    public List<Pacient> getAllPacients() {
        return pacientRepository.findAll();
    }
}
