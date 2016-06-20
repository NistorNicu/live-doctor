package com.doctor.service.api;

import com.doctor.entity.Pacient;
import com.doctor.entity.view.PacientSignupView;

import java.util.List;

/**
 * Created by Nicu on 6/17/2016.
 */
public interface PacientServiceApi {
    Pacient addPacient(PacientSignupView pacientView );
    List<Pacient> getAllPacients();
}
