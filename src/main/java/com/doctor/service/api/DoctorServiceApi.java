package com.doctor.service.api;


import com.doctor.entity.Doctor;
import com.doctor.entity.view.DoctorSignupView;
import org.springframework.stereotype.Service;

/**
 * Created by Nicu on 6/17/2016.
 */
public interface DoctorServiceApi {
          Doctor addDoctor(DoctorSignupView doctor);
}
