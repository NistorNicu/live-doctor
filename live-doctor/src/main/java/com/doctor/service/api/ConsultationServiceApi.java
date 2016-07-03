package com.doctor.service.api;

import com.doctor.entity.Consultation;
import com.doctor.entity.view.ConsultationPacientView;
import com.doctor.entity.view.CreateConsultationView;

import java.util.List;

/**
 * Created by Nicu on 6/17/2016.
 */
public interface ConsultationServiceApi {

    ConsultationPacientView createConsultation(CreateConsultationView consultationView);

    Consultation getConsultation(Long id);

    List<Consultation> getAllConsultations();
}
