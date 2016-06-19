package com.doctor.service.api;

import com.doctor.entity.Consultation;
import com.doctor.entity.view.CreateConsultationView;

/**
 * Created by Nicu on 6/17/2016.
 */
public interface ConsultationServiceApi {

    void createConsultation(CreateConsultationView consultationView);

    Consultation getConsultation(Long id);
}
