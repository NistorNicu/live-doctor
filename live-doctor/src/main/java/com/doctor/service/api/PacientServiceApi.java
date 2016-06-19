package com.doctor.service.api;

import com.doctor.entity.Pacient;
import com.doctor.entity.view.PacientSignupView;

/**
 * Created by Nicu on 6/17/2016.
 */
public interface PacientServiceApi {
    Pacient addPacient(PacientSignupView pacientView );
}
