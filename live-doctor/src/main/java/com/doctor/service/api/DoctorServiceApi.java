package com.doctor.service.api;


import com.doctor.entity.Consultation;
import com.doctor.entity.Doctor;
import com.doctor.entity.view.DoctorSignupView;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nicu on 6/17/2016.
 */
public interface DoctorServiceApi {
    Doctor addDoctor(DoctorSignupView doctor);

    List<Doctor> findEligibleDoctors(Consultation consultation);
}
